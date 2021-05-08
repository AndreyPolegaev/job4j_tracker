package ru.job4j.function.streameasy;
/**
 * of - получает исходные данные.
 * map - преобразует число в другое число.
 * filter - фильтрует поток элементов.
 * collect - собирает все элементы из source по заданным условиям map и filter.
 */

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EasyStream {

    private final Stream<Integer> input;
    private Function<Integer, Integer> map = x -> x;
    private Predicate<Integer> filter = f -> true;

    public EasyStream(Stream<Integer> input) {
        this.input = input;
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source.stream());
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        this.map = fun;
        return this;
    }

    public EasyStream filter(Predicate<Integer> fun) {
        this.filter = fun;
        return this;
    }

    public List<Integer> collect() {
       return input.filter(filter).map(map).collect(Collectors.toList());
    }
}