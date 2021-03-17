package ru.job4j.tracker;

public class FindItemByName implements UserAction {
    @Override
    public String name() {
        return "FindItemByName";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Введите имя заявки: ");
        Item[] items = tracker.findByName(name);
        if (items.length != 0) {
            for (Item temp : items) {
                System.out.println(temp);
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
