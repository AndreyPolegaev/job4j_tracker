package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Replace Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("our item id");
        Item item = new Item(input.askStr("our item name"));
        tracker.replace(id, item);
        return true;
    }
}
