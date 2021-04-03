package ru.job4j.tracker;

import java.util.List;

public class FindItemByName implements UserAction {
    private final Output out;

    public FindItemByName(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "FindItemByName";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Введите имя заявки: ");
        List<Item> items = tracker.findByName(name);
        if (items.size() != 0) {
            for (Item temp : items) {
                out.println(temp);
            }
        } else {
            out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
