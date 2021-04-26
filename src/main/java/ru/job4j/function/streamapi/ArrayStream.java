package ru.job4j.function.streamapi;

import java.util.List;
import java.util.stream.Collectors;

public class ArrayStream {
    public static void main(String[] args) {
        List<Integer> list = List.of(-1, 2, -3, 4, -5, 6, -7, 8, -9, 10);
        List<Integer> rsl = list.stream().filter(x -> x > 0).collect(Collectors.toList());
        rsl.forEach(System.out::println);
    }
}
