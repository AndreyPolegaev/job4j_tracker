package ru.job4j.oop.pojo;
/**
 * left shift object into array (need to implement remove object and shift that on the left)
 */
public class ShopDrop {
    public static Product[] leftShift(Product[] products, int index) {
        Product[] rsl = new Product[products.length];
        for (int i = 0; i < products.length; i++) {
            if (i == index) {
                while (index < products.length - 1) {
                    rsl[index] = products[index + 1];
                    index++;
                }
            } else {
                rsl[i] = products[i];
            }
        }
        return rsl;
    }
}