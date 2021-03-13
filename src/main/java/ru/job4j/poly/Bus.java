package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void move() {
        System.out.println("I can move!");
    }

    @Override
    public void passengers(int value) {
        if (value < 100) {
            System.out.println("We can go");
        } else {
            System.out.println("The bus is overloaded");
        }
    }

    @Override
    public int priceFuel(int quantity) {
        return quantity * 40;
    }
}
