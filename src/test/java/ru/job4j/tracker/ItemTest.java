package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void whenNaturalOrderById() {
        Item item1 = new Item("First");
        item1.setId(5);
        Item item2 = new Item("Second");
        item2.setId(2);
        Item item3 = new Item("Third");
        item3.setId(4);
        List<Item> list = Arrays.asList(item1, item2, item3);
        Collections.sort(list);
        List<Integer> expected = new ArrayList<>();
        for (Item temp : list) {
            expected.add(temp.getId());
        }
        assertThat(expected, is(Arrays.asList(2, 4, 5)));
    }

    @Test
    public void whenReverseOrderById() {
        Item item1 = new Item("First");
        item1.setId(5);
        Item item2 = new Item("Second");
        item2.setId(2);
        Item item3 = new Item("Third");
        item3.setId(4);
        List<Item> list = Arrays.asList(item1, item2, item3);
        Collections.sort(list, new SortDownById());
        List<Integer> expected = new ArrayList<>();
        for (Item temp : list) {
            expected.add(temp.getId());
        }
        assertThat(expected, is(Arrays.asList(5, 4, 2)));
    }
}