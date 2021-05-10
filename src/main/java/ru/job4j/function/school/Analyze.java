package ru.job4j.function.school;

/**
 * Класс Analyze получает статистику по аттестатам.
 */

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(x -> x.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(m -> new Tuple(m.getName(), Stream.of(m)
                .flatMap(r -> r.getSubjects().stream())
                .mapToInt(Subject::getScore).average()
                .getAsDouble())).collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(e -> e.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                .stream().map(p -> new Tuple(p.getKey(), p.getValue()))
                .collect(Collectors.toList());

    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(m -> new Tuple(m.getName(), Stream.of(m)
                .flatMap(r -> r.getSubjects().stream())
                .mapToDouble(Subject::getScore).sum()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(new Tuple("unknown", 0));
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(e -> e.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet()
                .stream().map(p -> new Tuple(p.getKey(), p.getValue()))
                .max(Comparator.comparing(Tuple::getScore)).orElse(new Tuple("unkown", 0));
    }
}
