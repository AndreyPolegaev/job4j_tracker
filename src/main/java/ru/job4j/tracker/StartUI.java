package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        item.setName("TestItem");
        item.setId(1);
        System.out.println(item);
    }
}
