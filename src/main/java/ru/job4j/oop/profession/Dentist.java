package ru.job4j.oop.profession;

public class Dentist extends Doctor {
    private int price;
    private String quality;

    public void info() {
        System.out.println("Hello im a dentist! I provide the best price and excellent quality service" + this.price + " " + this.quality);
    }
}
