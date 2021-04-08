package ru.job4j.collection.sortstring;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftData = left.split(". ");
        String[] rightData = right.split(". ");
        return Integer.compare(Integer.parseInt(leftData[0]), Integer.parseInt(rightData[0]));
    }
}
