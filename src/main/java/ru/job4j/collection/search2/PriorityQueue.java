package ru.job4j.collection.search2;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();
    private int index = 0;

    public void put(Task task) {
        for (Task temp : tasks) {
            if (task.getPriority() < temp.getPriority()) {
                this.tasks.add(index++, task);
                return;
            }
        }
        this.tasks.add(tasks.size(), task);
    }

    public Task take() {
        return tasks.poll();
    }
}
