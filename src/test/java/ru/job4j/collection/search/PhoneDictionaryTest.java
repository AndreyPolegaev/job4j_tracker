package ru.job4j.collection.search;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByNameEquals() {
        PhoneDictionary phoneDictionary = new PhoneDictionary();
        phoneDictionary.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        var person = phoneDictionary.find("Ars");
        assertThat(person.get(0), is(new Person("Petr", "Arsentev", "534872", "Bryansk")));
    }

    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        var persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenListIsEmpty() {
        PhoneDictionary phones = new PhoneDictionary();
        var persons = phones.find("Petr");
        assertThat(persons.isEmpty(), is(true));
    }
}