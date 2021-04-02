package ru.job4j.collection.list;

import org.junit.Test;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ConvertMatrix2ListTest {

    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] data = {
                {1, 2},
                {3, 4}
        };
        List<Integer> result = list.toList(data);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4);
        assertThat(result, is(expected));
    }
}