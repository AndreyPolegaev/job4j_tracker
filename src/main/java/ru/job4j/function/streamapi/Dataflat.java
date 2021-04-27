package ru.job4j.function.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dataflat {

    public static List<Integer> execute(Integer[][] data) {
        return Stream.of(data)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }
}
