package ru.job4j.collection.departments;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        List<String> rsl = new ArrayList<>();
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                if ("".equals(start)) {
                        start = el;
                } else {
                    start = start + "/" + el;
                }
                tmp.add(start);
            }
        }
        rsl.addAll(tmp);
        return rsl;
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs, Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp());
    }
}
