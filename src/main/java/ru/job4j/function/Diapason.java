package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Diapason {
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < end - start; i++) {
            list.add(func.apply((double) start + i));
        }
        return list;
    }
}
