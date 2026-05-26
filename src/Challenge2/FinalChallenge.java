package Challenge2;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class FinalChallenge {

    public static void main(String[] args) {

        Course pymc= new Course("PYMC", "Python Masterclass", 50);
        Course jmc= new Course("JMC", "Java Masterclass", 100);
        Course jgames = new Course("JGAME", "Creating games in Java");

        List<Student> students =
                Stream.generate(() -> Student.getRandomStudent(jmc, pymc, jgames))
                        .filter(s -> s.getYearEnrolled() <= LocalDate.now().getYear() - 4)
                        .limit(10000)
                        .toList();

        System.out.println(students
                .stream()
                .mapToInt(Student::getYearEnrolled)
                .summaryStatistics());

        long pymcCount = students.stream()
                .filter(s-> s.getEngagementMap().containsKey("PYMC"))
                .count();
        System.out.println("Students attending Python Masterclass = " + pymcCount);

        long jmcCount = students.stream()
                .filter(s-> s.getEngagementMap().containsKey("JMC"))
                .count();
        System.out.println("Students attending Java Masterclass = " + jmcCount);

        long jgamesCount = students.stream()
                .filter(s-> s.getEngagementMap().containsKey("JGAME"))
                .count();
        System.out.println("Students attending Java Masterclass = " + jgamesCount);

        long oneCourseTakers = students.stream()
                .filter(s-> s.getEngagementMap().size() == 1)
                .count();
        System.out.println("There are " + oneCourseTakers + " students taking 1 course");

        long twoCourseTakers = students.stream()
                .filter(s-> s.getEngagementMap().size() == 2)
                .count();
        System.out.println("There are " + twoCourseTakers + " students taking 2 courses");

        long threeCourseTakers = students.stream()
                .filter(s-> s.getEngagementMap().size() == 3)
                .count();
        System.out.println("There are " + threeCourseTakers + " students taking 3 courses");

        double averagePercent1 = students.stream()
                .collect(averagingDouble(
                        s -> s.getEngagementMap().containsKey("PYMC") ? 1.0 : 0.0
                )) * 100;

        System.out.println("Average percent of PYMC course " + averagePercent1);

//        double activityCount1 = students.stream();



    }
}
