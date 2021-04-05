package ru.job4j.tracker;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void whenNaturalOrderById() {
        Item item1 = new Item("First");
        Item item2 = new Item("Second");
        Item item3 = new Item("Third");
        item1.setId(5);
        item2.setId(2);
        item3.setId(4);
        List<Item> list = Arrays.asList(item1, item2, item3);
        Collections.sort(list);
        List<Item> expected = Arrays.asList(
                item2, item3, item1
        );
        assertThat(expected, is(list));
    }

    @Test
    public void whenReverseOrderById() {
        Item item1 = new Item("First");
        Item item2 = new Item("Second");
        Item item3 = new Item("Third");
        item1.setId(5);
        item2.setId(2);
        item3.setId(4);
        List<Item> list = Arrays.asList(item1, item2, item3);
        Collections.sort(list, new SortDownById());
        List<Item> expected = Arrays.asList(
                item1, item3, item2
        );
        assertThat(expected, is(list));
    }
}