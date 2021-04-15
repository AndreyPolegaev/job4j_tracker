package ru.job4j.collection.map;

import java.util.*;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<Character, Integer> mapLeft = new HashMap<>();
        Map<Character, Integer> mapRight = new HashMap<>();
        for (int i = 0; i < left.length(); i++) {
            mapLeft.putIfAbsent(left.charAt(i), 0);
            mapLeft.computeIfPresent(left.charAt(i), (key, value) -> value + 1);
            mapRight.putIfAbsent(right.charAt(i), 0);
            mapRight.computeIfPresent(right.charAt(i), (key, value) -> value + 1);
        }
        return mapLeft.equals(mapRight);
    }
}
