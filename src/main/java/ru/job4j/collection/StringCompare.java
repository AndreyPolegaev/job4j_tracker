package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        char[] leftChar = left.toCharArray();
        char[] rightChar = right.toCharArray();
        int max = Math.max(leftChar.length, rightChar.length);
        int copies = 0;
        char ch = (char) copies;
        List<Character> listLeft = new ArrayList<>(Collections.nCopies(max, ch));
        for (int i = 0; i < leftChar.length; i++) {
            listLeft.set(i, leftChar[i]);
        }
        List<Character> listRight = new ArrayList<>(Collections.nCopies(max, ch));
        for (int i = 0; i < rightChar.length; i++) {
            listRight.set(i, rightChar[i]);
        }
        for (int i = 0; i < max; i++) {
            if (listLeft.get(i) > listRight.get(i)) {
                rsl = 1;
                break;
            } else if (listLeft.get(i) < listRight.get(i)) {
                rsl = -1;
                break;
            }
        }
        return rsl;
    }
}
