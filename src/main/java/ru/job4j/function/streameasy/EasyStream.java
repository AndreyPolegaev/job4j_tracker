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

public class EasyStream {

    private List<Integer> list;

    private EasyStream(List<Integer> list) {
        this.list = list;
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        list = list.stream().map(fun).collect(Collectors.toList());
        return this;
    }

    public EasyStream filter(Predicate<Integer> fun) {
        list = list.stream().filter(fun).collect(Collectors.toList());
        return this;
    }

    public List<Integer> collect() {
        return List.copyOf(list);
    }
}