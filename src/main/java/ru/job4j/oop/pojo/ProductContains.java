package ru.job4j.oop.pojo;

public class ProductContains {
    public static void main(String[] args) {
        Product first = new Product("Milk", 100);
        Product second = new Product("Milk", 100);
        System.out.println(first == second);
        System.out.println(first.equals(second));
    }
}
