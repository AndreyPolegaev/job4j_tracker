package ru.job4j.collection.search2;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();
    private int index = 0;

    public void put(Task task) {
        if (tasks.isEmpty()) {     /* если коллекция пустая добавить объект*/
            this.tasks.add(index, task);
        } else {
            for (Task temp : tasks) {
                if (task.getPriority() < temp.getPriority()) {
                    this.tasks.add(index, task);
                    index++;
                    break;
                }
            }
        }
    }

    public Task take() {
        return tasks.poll();
    }
}
