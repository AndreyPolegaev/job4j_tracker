package ru.job4j.collection.list;
/**
 * Метод convert должен пройтись по всем элементам всех массивов в списке list
 * и добавить их в список rsl.
 * Массивы в списке list могут быть разного размера.
 */
import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();
        for (int[] temp : list) {
            for (int i : temp) {
                rsl.add(i);
            }
        }
        return rsl;
    }
}