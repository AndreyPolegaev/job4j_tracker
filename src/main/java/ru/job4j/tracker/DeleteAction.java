package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Введите id заявки, которую надо удалить");
        if (tracker.delete(id)) {
            System.out.println("Удалено успешно");
        } else {
            System.out.println("Заявки с таким id не найдено");
        }
        return true;
    }
}
