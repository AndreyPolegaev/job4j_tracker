package ru.job4j.oop.transport;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("I can go only forward on the ground");
    }
}
