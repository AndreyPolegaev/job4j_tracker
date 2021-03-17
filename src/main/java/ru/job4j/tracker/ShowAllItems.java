package ru.job4j.tracker;

public class ShowAllItems implements UserAction {
    @Override
    public String name() {
        return "Show All Items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] data = tracker.findAll();
        for (Item temp : data) {
            System.out.println(temp);
        }
        return true;
    }
}
