package ru.job4j.oop.animals;

public class Animal {
    private String nameClass = getClass().getSimpleName();

    public void sound() {
        System.out.println(nameClass + " make a sound");
    }

    public String getNameClass() {
        return this.nameClass;
    }

    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.sound();
        Animal cat = new Cat();
        cat.sound();
        Animal[] animals = new Animal[]{dog, cat};
        for (Animal a : animals) {
            a.sound();
        }
    }
}
