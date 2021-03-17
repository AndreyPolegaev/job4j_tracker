package ru.job4j.tracker;

public class ReplaceItem implements UserAction {
    @Override
    public String name() {
        return "Edit Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Введите id заявки которую надо заменить: ");
        Item item = new Item(input.askStr("Введите новое имя заявки: "));
        boolean rsl = tracker.replace(id, item);
        if (rsl) {
            System.out.println("Успешно");
        } else {
            System.out.println("На найдеена заявка в таким id");
        }
        return true;
    }
}
