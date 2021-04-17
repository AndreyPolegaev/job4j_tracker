package ru.job4j.collection.departments;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        List<String> rsl = new ArrayList<>();
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                if (!tmp.isEmpty()) {
                    if (tmp.contains(el)) {
                        start = el;
                        continue;
                    }
                    tmp.add(start + "/" + el );
                } else {
                    tmp.add(el);
                    start = el;
                }
            }
        }
        rsl.addAll(tmp);
        return rsl;
    }

    public static void sortAsc(List<String> orgs) {
    }

    public static void sortDesc(List<String> orgs) {
    }
}
