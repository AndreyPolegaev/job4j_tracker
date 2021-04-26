package ru.job4j.function.streamapi.studenttomap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExecuteStident {
    public Map<String, Student> execute(List<Student> students) {
        return students.stream()
                .distinct()
                .collect(Collectors.toMap(e -> e.getSurname(), e -> e));
    }
}
