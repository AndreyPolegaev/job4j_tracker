package ru.job4j.oop.animals;

public class Dog extends Animal {

    @Override
    public void sound() {
        System.out.println(super.getNameClass() + " gav gav");
    }

    public void size() {
        System.out.println("Im a big and angry dog");
    }
}
