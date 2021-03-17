package ru.job4j.tracker;

public class FindById implements UserAction {
    @Override
    public String name() {
        return "Find by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Введите id заявки: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
        return true;
    }
}
