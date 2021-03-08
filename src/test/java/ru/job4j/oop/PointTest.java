package ru.job4j.oop;
import org.junit.Test;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void distanceFirstTest() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double rsl = a.distance(b);
        assertEquals(2.0, rsl, 0.01);
    }

    @Test
    public void distanceSecondTest() {
        Point a = new Point(2, 3);
        Point b = new Point(4, 1);
        double rsl = a.distance(b);
        assertThat(rsl, closeTo(2.82, 0.01));
    }
}