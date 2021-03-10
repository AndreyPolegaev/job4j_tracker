package ru.job4j.oop.pojo;
/**
 * left shift object into array
 */
public class ShopDrop {
    public static Product[] leftShift(Product[] products, int index) {

        if (index == products.length - 1) {
            products[index] = null;
        } else if (products[index + 1] != null) {
            products[index] = products[index + 1];
            products[index + 1] = null;
        }
        return products;
    }
}
