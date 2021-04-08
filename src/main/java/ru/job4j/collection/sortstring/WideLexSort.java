package ru.job4j.collection.sortstring;

import java.util.Comparator;

public class WideLexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        String[] dataLeft = left.split(". ");
        String[] dataRight = right.split(". ");
        int steps = Math.min(dataLeft[0].length(), dataRight[0].length());
        String s1 = dataLeft[0];
        String s2 = dataRight[0];
        for (int i = 0; i < steps; i++) {
            rsl = Integer.compare(s1.charAt(i), s2.charAt(i));
            if (rsl != 0) {
                break;
            }
        }
        return rsl;
    }
}
