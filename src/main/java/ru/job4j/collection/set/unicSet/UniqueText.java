package ru.job4j.collection.set.unicSet;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String temp : origin) {
            check.add(temp);
        }
        for (String temp : text) {
            if (!check.contains(temp)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
