package ru.job4j.collection.ordersort;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;

public class UserTest {
    @Test
    public void whenAsc() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 31));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Ivan", 31)));
        assertThat(it.next(), is(new User("Petr", 32)));
    }

    @Test
    public void whenComparePertVSIvan() {
        int rsl = new User("Petr", 32)
                .compareTo(
                        new User("Ivan", 31)
                );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenNamesAreEqualsCompateage() {
        Set<User> users = new TreeSet<>();
        Collections.addAll(
                users,
                new User("Petr", 30),
                new User("Petr", 35));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Petr", 30)));
        assertThat(it.next(), is(new User("Petr", 35)));
    }
}