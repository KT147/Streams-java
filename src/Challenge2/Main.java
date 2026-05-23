package Challenge2;

import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Course pymc = new Course("PYMC", "Python");
        Course jmc = new Course("JC", "Java");
        Student tim = new Student("AU", 2019, 30, "M", true, jmc, pymc);

        System.out.println(tim);


        List<Student> students = Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(1000)
                .toList();

        long maleStudents = students.stream()
                .filter(student -> student.getGender().equalsIgnoreCase("M"))
                .count();

        long femaleStudents = students.stream()
                .filter(student -> student.getGender().equalsIgnoreCase("F"))
                .count();

        long lessThan30 = students.stream()
                .filter(student -> student.getAge() < 30)
                .count();

        long between30and60 = students.stream()
                .filter(student -> student.getAge() > 30 && student.getAge() < 60)
                .count();

        long over60 = students.stream()
                .filter(student -> student.getAge() < 60)
                .count();

        IntSummaryStatistics stats = students.stream()
                .collect(Collectors.summarizingInt(Student::getAge));

        List<String> studentCountries = students.stream()
                .map(Student::getCountryCode)
                //ei korda samu
                .distinct()
                .sorted()
                .toList();

        boolean isActive = students.stream()
                .anyMatch(student ->
                        student.getMonthsSinceActive() == 0 &&
                                student.getYearsSinceEnrolled() >= 7
                );

        List<Student> fiveStudents = students.stream()
                        .limit(5)
                                .toList();


        System.out.println("There are " + maleStudents + " male students");
        System.out.println("There are " + femaleStudents + " female students");
        System.out.println("There are " + lessThan30 + " students less than 30 years old");
        System.out.println("There are " + between30and60 + " students between 30 and 60");
        System.out.println("There are " + over60 + " students over 60");
        System.out.println("Average student age is " + (int) stats.getAverage());
        System.out.println("Students are from: " + studentCountries);
        System.out.println("isActive= " + isActive);
        fiveStudents.forEach(System.out::println);


//        Student[] students2 = new Student[1000];
//        var longTimeLearners = Arrays.stream(students2)
//                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) &&
//                        (s.getMonthsSinceActive() < 12))
//                .filter(s -> !s.hasProgrammingExperience())
//                .limit(5)
//                .toArray(Student[]::new);
//        var learners = Arrays.stream(students2)
//                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) &&
//                        (s.getMonthsSinceActive() < 12))
//                .filter(s -> !s.hasProgrammingExperience())
//                .limit(5)
//                .collect(Collectors.toList());
//
//        Collections.shuffle(learners);


    }
}
