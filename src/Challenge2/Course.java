package Challenge2;

public class Course {

    private String courseCode;
    private String title;
    private int lectureCount;

    public Course() {
        if (lectureCount <= 0) {
            lectureCount = 1;
        }
    }

    public int getLectureCount() {
        return lectureCount;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public Course(String courseCode, String title) {
        this.courseCode = courseCode;
        this.title = title;
        this.lectureCount = 40;
    }

    @Override
    public String toString() {
        return "%s %s".formatted(courseCode,title);
    }
}
