package ru.job4j.oop.shop;

public class Shop {
    public static void main(String[] args) {
        Product product = of("Oil", 100);
        System.out.println(product.label());
    }

    public static Product of(String name, int price) {
        if ("Oil".equals(name)) {
            LiquidationProduct liquidationProduct = new LiquidationProduct(name, price);
            return liquidationProduct.getProduct();
        }
        return new Product(name, price);
    }
}
