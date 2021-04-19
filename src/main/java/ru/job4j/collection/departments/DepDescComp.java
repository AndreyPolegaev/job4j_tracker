package ru.job4j.collection.departments;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        String[] leftData = left.split("/");
        String[] rightData = right.split("/");
        rsl = rightData[0].compareTo(leftData[0]);
        if (rsl == 0) {
            rsl = left.compareTo(right);
        }
        return rsl;
    }
}

