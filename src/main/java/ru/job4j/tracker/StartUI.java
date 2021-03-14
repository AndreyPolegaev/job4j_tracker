package ru.job4j.tracker;
import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                Item item = new Item(scanner.nextLine());
                Item rslItem =  tracker.add(item);
                System.out.println(rslItem + " Добавлено успешно");
            } else if (select == 1) {
               Item[] data = tracker.findAll();
               for (Item temp : data) {
                   System.out.println(temp);
               }
            } else if (select == 2) {
                System.out.println("Введите id заявки которую надо заменить: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Введите имя заявки на которое заменить: ");
                Item item = new Item(scanner.nextLine());
                boolean rsl = tracker.replace(id, item);
                if (rsl) {
                    System.out.println("Успешно");
                } else {
                    System.out.println("На найдеена заявка в таким id");
                }
            } else if (select == 3) {
                System.out.println("Введите id заявка которое удалить: ");
                int id = Integer.parseInt(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("Удалено успешно");
                } else {
                    System.out.println("Заявки с таким id не найдено");
                }
            } else if (select == 4) {
                System.out.println("Введите id заявки: ");
                int id = Integer.parseInt(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Заявка с таким id не найдена");
                }
            } else if (select == 5) {
                System.out.println("Введите имя заявки: ");
                String name = scanner.nextLine();
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
                + "Select:"
        );
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
