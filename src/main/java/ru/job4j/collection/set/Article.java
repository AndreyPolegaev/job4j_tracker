package ru.job4j.collection.set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean rsl = true;
        String[] lineData = line.replaceAll("\\p{Punct}", "").split(" ");
        String[] originData = origin.replaceAll("\\p{Punct}", "").split(" ");
        Set<String> set = new HashSet<>();
        Collections.addAll(set, originData);
        for (String temp : lineData) {
            if (!set.contains(temp)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}
