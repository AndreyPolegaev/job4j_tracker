package ru.job4j.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DiapasonTest {

    @Test
    public void whenFirstFunction() {
        List<Double> rsl = new Diapason().diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11.0, 13.0, 15.0);
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenSecondFunction() {
        List<Double> rsl = new Diapason().diapason(5, 8, x -> Math.pow(x, 2) + 1);
        List<Double> expected = Arrays.asList(26.0, 37.0, 50.0);
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenThirdFunction() {
        List<Double> rsl = new Diapason().diapason(5, 8, x -> Math.pow(2, x) + 1);
        List<Double> expected = Arrays.asList(33.0, 65.0, 129.0);
        assertThat(rsl, is(expected));
    }

}