package ru.job4j.collection.map.listtomap;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;

public class OrderConvertTest {
    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Dress")));
    }

    @Test
    public void whenTheSame() {
        List<Order> orders = new ArrayList<>();
        Collections.addAll(orders,
                new Order("12rt25", "FirstOrder"),
                new Order("12rt25", "SecondOrder"));
        Map<String, Order> map = OrderConvert.process(orders);
        assertEquals(map.get("12rt25"), new Order("12rt25", "SecondOrder"));
        assertEquals(map.size(), 1);
    }
}