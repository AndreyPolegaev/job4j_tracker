package ru.job4j.collection.map.listtomap;

import java.util.HashMap;
import java.util.List;

public class OrderConvert {

    public static HashMap<String, Order> process(List<Order> orders) {
        HashMap<String, Order> map = new HashMap<>();
        for (Order temp : orders) {
            map.put(temp.getNumber(), temp);
        }
        return map;
    }
}
