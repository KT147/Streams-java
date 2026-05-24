package Challenge2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainChallenge {

    public static void main(String[] args) {

        Course pymc = new Course("PYMC", "Python Masterclass", 50);
        Course jmc = new Course("JMC", "Java Masterclass", 100);
        Course jg = new Course("JG", "Creating games in Java");

        List<Student> students =
                Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                        .limit(5000)
                        .toList();


        double javaPercentage = students.stream()
                .map(student -> student.getPercentComplete("JMC"))
                .reduce(
                        0.00,
                        (a, b) -> a + b / students.size());
        System.out.println("Java average % complete is " + javaPercentage);

        Set<Student> threeQuartersComplete = students.stream()
                .filter(s -> s.getPercentComplete("JMC") >= javaPercentage * 1.25)
                .filter(s -> s.getMonthsSinceActive() == 0)
                .limit(10)
                .collect(() -> new TreeSet<>(Comparator.comparing(
                        Student::getYearEnrolled)), TreeSet::add, TreeSet::addAll);
        threeQuartersComplete.forEach(System.out::println);

        threeQuartersComplete.forEach(s -> s.addCourse(jg));
        threeQuartersComplete.forEach(System.out::println);



    }
}
