package ru.job4j.collection.map.passport;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

public class PassportOfficeTest {
    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void whenCitizenIsAlreadyPresents() {
        Citizen citizen = new Citizen("234fff232", "Silvester Stallone");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.add(new Citizen("234fff232", "Silvester Stallone")), is(false));
    }

    @Test
    public void whenPassportisAbsent() {
        Citizen citizen = new Citizen("234fff232", "Silvester Stallone");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get("xxxxxxx"), is(nullValue()));
    }
}