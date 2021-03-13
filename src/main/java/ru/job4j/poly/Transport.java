package ru.job4j.poly;
/**
 * Интерфейс определяет любой вид транспорта
 */
public interface Transport {
    void move();

    void passengers(int value);

    int priceFuel(int quantity);
}
