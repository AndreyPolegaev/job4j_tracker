package ru.job4j.collection.departments;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        String[] leftData = left.split("/");
        String[] rightData = right.split("/");
        int steps = Math.min(leftData.length, rightData.length);
        for (int i = 0; i < steps; i++) {
            rsl = rightData[i].compareTo(leftData[i]);
            if (rsl == 0) {
                rsl = left.compareTo(right);
                break;
            } else {
                return rsl;
            }
        }
        return rsl;
    }
}

