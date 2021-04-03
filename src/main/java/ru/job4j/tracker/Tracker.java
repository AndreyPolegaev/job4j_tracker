package ru.job4j.tracker;
import java.util.ArrayList;
import java.util.List;

/**
 * public Item add(Item item) - добавление заявок
 * public Item[] findAll() - получение списка всех заявок
 * public Item[] findByName(String key) - получение списка по имени
 * public Item findById(int id) - получение заявки по id
 */
public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> item = new ArrayList<>();
        for (Item temp : items) {
            if (temp.getName().equals(key)) {
                item.add(temp);
            }
        }
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(int id, Item item) {
        boolean rsl = false;
        int index = indexOf(id);
        if (index != -1) {
            items.set(index, item);
            item.setId(id);
            rsl = true;
        }
        return rsl;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean delete(int id) {
        boolean rsl = false;
        for (Item temp : items) {
            if (temp.getId() == id) {
                rsl = items.remove(temp);
                break;
            }
        }
        return rsl;
    }
}