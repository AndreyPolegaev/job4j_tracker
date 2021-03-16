package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        Item item = new Item(input.askStr("Enter name"));
        Item rslItem =  tracker.add(item);
        System.out.println(rslItem + " Добавлено успешно");
    }

    public static void showAllItems(Tracker tracker) {
        Item[] data = tracker.findAll();
        for (Item temp : data) {
            System.out.println(temp);
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        int id = input.askInt("Введите id заявки которую надо заменить: ");
        Item item = new Item(input.askStr("Введите новое имя заявки: "));
        boolean rsl = tracker.replace(id, item);
        if (rsl) {
            System.out.println("Успешно");
        } else {
            System.out.println("На найдеена заявка в таким id");
        }
    }

    public static void deteleItem(Input input, Tracker tracker) {
        int id = input.askInt("Введите id заявки, которую надо удалить: ");
        if (tracker.delete(id)) {
            System.out.println("Удалено успешно");
        } else {
            System.out.println("Заявки с таким id не найдено");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        int id = input.askInt("Введите id заявки: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        String name = input.askStr("Введите имя заявки: ");
        Item[] items = tracker.findByName(name);
        if (items.length != 0) {
            for (Item temp : items) {
                System.out.println(temp);
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Выберете действие");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction()
        };
        new StartUI().init(input, tracker, actions);
    }
}
