package ru.job4j.collection.set;

import org.junit.Test;
import ru.job4j.collection.sortstring.LexSort;
import ru.job4j.collection.sortstring.WideLexSort;

import java.util.Arrays;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LexSortTest {

    @Test
    public void sortNum1and2and10() {
        String[] input = {
                "10. Task.",
                "1. Task.",
                "2. Task."
        };
        String[] out = {
                "1. Task.",
                "2. Task.",
                "10. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }

    @Test
    public void sortTest() {
        String[] input = {
                "7.0.1. Task1 Task2 Task3",
                "7.1.2. Task1 Task2 Task3",
                "7.2.0. Task1 Task2 Task3",
                "8.0. Task1 Task2 Task3",
                "6.0.2. Task1 Task2 Task3",
                "6.1.0. Task1 Task2 Task3",
                "6.0.1. Task1 Task2 Task3"
        };
        String[] out = {
                "6.0.1. Task1 Task2 Task3",
                "6.0.2. Task1 Task2 Task3",
                "6.1.0. Task1 Task2 Task3",
                "7.0.1. Task1 Task2 Task3",
                "7.1.2. Task1 Task2 Task3",
                "7.2.0. Task1 Task2 Task3",
                "8.0. Task1 Task2 Task3",
        };
        Arrays.sort(input, new WideLexSort());
        assertThat(input, is(out));
    }
}