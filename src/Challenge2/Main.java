package Challenge2;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Course pymc = new Course("PYMC", "Python");
        Course jmc = new Course("JC", "Java");
//        Student tim = new Student("AU", 2019, 30, "M", true, jmc, pymc);
//
//        System.out.println(tim);


        Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(10)
                .forEach(System.out::println);

    }
}
