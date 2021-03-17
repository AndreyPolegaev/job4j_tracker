package ru.job4j.tracker;

public class ReplaceItem implements UserAction {
    private final Output out;

    public ReplaceItem(Output out) {
        this.out = out;
    }

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
             out.println("Успешно");
        } else {
             out.println("На найдеена заявка в таким id");
        }
        return true;
    }
}
