package ru.job4j.collection.map;

import java.util.*;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < left.length(); i++) {
            map.putIfAbsent(left.charAt(i), 0);
            map.computeIfPresent(left.charAt(i), (key, value) -> value + 1);
        }
        for (Character temp : right.toCharArray()) {
            if (!map.containsKey(temp)) {
                return false;
            } else if (map.get(temp) == 1) {
                map.remove(temp);
            } else if (map.get(temp) > 1) {
                map.replace(temp, (map.get(temp) - 1));
            }
        }
        return map.isEmpty();
    }
}
