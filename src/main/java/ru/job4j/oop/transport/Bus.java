package ru.job4j.oop.transport;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("I can turn on the left / on the right");
    }
}
