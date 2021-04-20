package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionInterfaceUsage {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biCon = (s1, s2) -> map.put(s1, s2);
        biCon.accept(1, "one");
        biCon.accept(2, "two");
        biCon.accept(3, "three");
        biCon.accept(4, "four");
        biCon.accept(5, "five");
        biCon.accept(6, "six");
        biCon.accept(7, "seven");
        BiPredicate<Integer, String> biPred = (i, s) -> i % 2 == 0 || s.length() == 4;
        for (Integer i : map.keySet()) {
            System.out.println(biPred.test(i, map.get(i)));
        }

        System.out.println();

        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());
        Consumer<String> con = (s -> System.out.println(s));
        for (String temp : sup.get()) {
            con.accept(temp);
        }

        System.out.println();

        Function<String, String> func = (s -> s.toUpperCase());
        for (String s : sup.get()) {
            System.out.println(func.apply(s));
        }
    }
}
