package ru.job4j.function;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {
    public static void main(String[] args) {
        Comparator<String> cmpDescSize = (left, right) ->  {
            System.out.println("compare " + left + " : " + right);
            return Integer.compare(right.length(), left.length());
        };
        List<String> list = Arrays.asList("Andrey", "Masha", "Jeck", "Tom", "Ma");
        list.sort(cmpDescSize);
        System.out.println(list);
    }
}
