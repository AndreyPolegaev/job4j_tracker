package ru.job4j.oop.pojo;
/**
 * left shift object into array (need to implement remove object and shift that on the left)
 */
public class ShopDrop {
    public static Product[] leftShift(Product[] products, int index) {
        for (int i = index; i < products.length - 1; i++) {
            products[i] = products[i + 1];
        }
        products[products.length - 1] = null;
        return products;
    }
}