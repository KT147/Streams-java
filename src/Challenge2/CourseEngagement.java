package Challenge2;

import java.time.LocalDate;

public class CourseEngagement {

    private final Course course;
    private final LocalDate enrollmentDate;
    private String engagementType;
    private int lastLecture;
    private LocalDate lastActivityDate;

    public CourseEngagement(Course course, LocalDate enrollmentDate, String engagementType) {
        this.course = course;
        this.enrollmentDate = this.lastActivityDate = enrollmentDate;
        this.engagementType = engagementType;
    }

    public String getCourseCode() {
        return course.getCourseCode();
    }

    public int getEnrollmentYear() {
        return enrollmentDate.getYear();
    }

    public String getEngagementType() {
        return engagementType;
    }

    public int getLastLecture() {
        return lastLecture;
    }

    public int getLastActivityYear() {
        return lastActivityDate.getYear();
    }

    public int getLastActivityMonth() {
        return lastActivityDate.getMonthValue();
    }

    public int getMonthsSinceActivity() {
        int month = getLastActivityMonth();
        int year = getLastActivityYear();
        int currentYear = LocalDate.now().getYear();
        int currentMonth = LocalDate.now().getMonthValue();
        if (currentYear != year) {
            return ((currentYear - year) * 12) + (currentMonth - month);
        }
        return currentMonth - month;
    }

    public double getPercentComplete() {
        int lectureCount = course.getLectureCount();
        return (lastLecture * 100.00) / lectureCount;
    }

    void watchLecture(int lectureNumber, LocalDate currentDate) {
        lastLecture = Math.max(lectureNumber, lastLecture);
        lastActivityDate = currentDate;
        engagementType = "Lecture " + lastLecture;
    }

    @Override
    public String toString() {
        return "%s: %s %d %s [%d]".formatted(course.getCourseCode(), getLastActivityMonth(), getLastActivityYear(), engagementType, getMonthsSinceActivity());
    }
}
