package ru.job4j.oop.profession;

public class Dentist extends Doctor {
    private int price;
    private String quality;

    public Dentist(String name, String surname, String education,
                   String birthday, int price, String quality) {
        super(name, surname, education, birthday);
        this.price = price;
        this.quality = quality;
    }

    public void info() {
        System.out.println("Hello im a dentist! I provide the best price and "
               + "excellent quality service" + this.price + " " + this.quality);
    }
}