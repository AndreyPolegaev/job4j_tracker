package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Выберете действие");
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                Item item = new Item(input.askStr("Enter name"));
                Item rslItem =  tracker.add(item);
                System.out.println(rslItem + " Добавлено успешно");
            } else if (select == 1) {
               Item[] data = tracker.findAll();
               for (Item temp : data) {
                   System.out.println(temp);
               }
            } else if (select == 2) {
                int id = input.askInt("Введите id заявки которую надо заменить: ");
                Item item = new Item(input.askStr("Введите имя заявки на которое заменить: "));
                boolean rsl = tracker.replace(id, item);
                if (rsl) {
                    System.out.println("Успешно");
                } else {
                    System.out.println("На найдеена заявка в таким id");
                }
            } else if (select == 3) {
                int id = input.askInt("Введите id заявки, которую надо удалить: ");
                if (tracker.delete(id)) {
                    System.out.println("Удалено успешно");
                } else {
                    System.out.println("Заявки с таким id не найдено");
                }
            } else if (select == 4) {
                int id = input.askInt("Введите id заявки: ");
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Заявка с таким id не найдена");
                }
            } else if (select == 5) {
                String name = input.askStr("Введите имя заявки: ");
                Item[] items = tracker.findByName(name);
                if (items.length != 0) {
                    for (Item temp : items) {
                        System.out.println(temp);
                    }
                } else {
                    System.out.println("Заявки с таким именем не найдены");
                }
            } else if (select == 6) {
               run = false;
            } else {
                System.out.println("Не верный ввод");
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu. "
                + "\n0. Add new Item\n"
                + "1. Show all items\n"
                + "2. Edit item\n"
                + "3. Delete item\n"
                + "4. Find item by Id\n"
                + "5. Find items by name\n"
                + "6. Exit Program\n"

        );
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
