package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item first = new Item();
        first.setName("First Item");
        tracker.add(first);
        Item rsl = tracker.findById(1);
        System.out.println(rsl.getId() + " " + rsl.getName());

        Item[] findAll = tracker.findAll();
        for (Item temp : findAll) {
            System.out.println(temp.getId() + " " + temp.getName());
        }

        Item[] findByName = tracker.findByName("First Item");
        for (Item temp : findByName) {
            System.out.println(temp.getId());
        }
    }
}
