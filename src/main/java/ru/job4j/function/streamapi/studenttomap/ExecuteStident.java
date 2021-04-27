package ru.job4j.function.streamapi.studenttomap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExecuteStident {
    public Map<String, Student> execute(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(
                        Student::getSurname,
                        e -> e,
                        (oldValue, newValue) -> newValue));
    }
}
