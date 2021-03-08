package ru.job4j.oop;
import static java.lang.Math.sqrt;
/**
 * Triangle`s area
 */
public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point first, Point second, Point third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public double period(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    public boolean exist(double ab, double ac, double bc) {
        return ((ab + ac) > bc && (ab + bc) > ac && (ac + bc) > ab);
    }

    public double area() {
        double rsl = -1;
        double ab = first.distance(second);
        double bc = second.distance(third);
        double ac = first.distance(third);
        if (this.exist(ab, ac, bc)) {
            double p = this.period(ab, bc, ac);
            rsl = sqrt(p * (p - ab) * (p - bc) * (p - ac));
        }
        return rsl;
    }
}
