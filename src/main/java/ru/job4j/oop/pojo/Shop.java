package ru.job4j.oop.pojo;
/**
 * null object
 */
public class Shop {
    public static void main(String[] args) {
        Product[] product = new Product[5];
        product[0] = new Product("Milk", 10);
        product[1] = new Product("Bread", 4);
        product[2] = new Product("Egg", 19);
        for (int i = 0; i < product.length; i++) {
            if (product[i] != null) {
                System.out.println(product[i].getName() + " : " + product[i].getCount());
            }
        }
    }

    public static int indexOfNull(Product[] products) {
        int rsl = -1;
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }
}
