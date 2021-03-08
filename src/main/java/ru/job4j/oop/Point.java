package ru.job4j.oop;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
/**
 * Distance between two points.
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point that) {
        return sqrt(pow(that.x - this.x, 2) + pow(that.y - this.y, 2));
    }
}
