package ru.job4j.function.streamapi.studenttomap;

import org.junit.Test;
import java.util.List;
import java.util.Map;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ExecuteStidentTest {

    @Test
    public void whenDuplicates() {
        List<Student> students = List.of(
                new Student(10, "Petrov"),
                new Student(10, "Petrov"),
                new Student(50, "Ivanov"),
                new Student(50, "Ivanov"),
                new Student(1, "Molotov"),
                new Student(100, "Stalin")
        );
        Map<String, Student> rsl = new ExecuteStident().execute(students);
        Map<String, Student> expected = Map.of(
                "Petrov", new Student(10, "Petrov"),
                "Ivanov", new Student(50, "Ivanov"),
                "Molotov", new Student(1, "Molotov"),
                "Stalin", new Student(100, "Stalin")
        );
        assertThat(rsl, is(expected));
    }
}