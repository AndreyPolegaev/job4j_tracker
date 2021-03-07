package ru.job4j.oop;
/**
 * public void exchange method() removes called object's value (load field)
 * and add this value to another object.
 */
public class Battery {
    private int load;

    public Battery(int load) {
        this.load = load;
    }

    public void exchange(Battery another) {
        another.load += this.load;
        this.load = 0;
    }

    public void showInfo() {
        System.out.println("Load is... " + this.load + " %");
    }

    public static void main(String[] args) {
        Battery first = new Battery(20);
        Battery second = new Battery(5);
        first.showInfo();
        second.showInfo();
        first.exchange(second);
        System.out.println();
        first.showInfo();
        second.showInfo();
    }
}
