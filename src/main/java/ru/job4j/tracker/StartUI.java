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

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Выберете действие");
            if (select == 0) {
                createItem(input, tracker);
            } else if (select == 1) {
               showAllItems(tracker);
            } else if (select == 2) {
                replaceItem(input, tracker);
            } else if (select == 3) {
               deteleItem(input, tracker);
            } else if (select == 4) {
                findItemById(input, tracker);
            } else if (select == 5) {
               findItemByName(input, tracker);
            } else if (select == 6) {
               run = false;
            } else {
                System.out.println("Не верный ввод");
            }
        }
    }

    private void showMenu() {
        String ln = System.lineSeparator();
        System.out.println(
                      "Menu. " + ln
                + "0. Add new Item" + ln
                + "1. Show all items" + ln
                + "2. Edit item" + ln
                + "3. Delete item" + ln
                + "4. Find item by Id" + ln
                + "5. Find items by name" + ln
                + "6. Exit Program" + ln

        );
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
