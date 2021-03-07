package ru.job4j.oop;

import org.junit.Test;

import static org.junit.Assert.*;

public class MaxTest {

    @Test
    public void whenTwoParameters() {
        assertEquals(2, Max.max(1, 2));
    }

    @Test
    public void whenThreeParameters() {
        assertEquals(5, Max.max(1, 2, 5));
    }

    @Test
    public void whenFourParameters() {
        assertEquals(10, Max.max(-5, 0, 10, 6));
    }
}