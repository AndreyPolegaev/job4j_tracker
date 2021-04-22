package ru.job4j.function.folder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SearchFolder {

    public static List<Folder> filter(List<Folder> list, Predicate<Folder> pred) {
        List<Folder> rsl = new ArrayList<>();
        for (Folder temp : list) {
           if (pred.test(temp)) {
               rsl.add(temp);
           }
        }
        return rsl;
    }

    public static List<Folder> filter2(List<Folder> list, Predicate<Folder> pred) {
        return list.stream().filter(pred).collect(Collectors.toList());
    }
}
