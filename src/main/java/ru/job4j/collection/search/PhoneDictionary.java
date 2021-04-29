package ru.job4j.collection.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (var temp : persons) {
            if (temp.info().contains(key)) {
                result.add(temp);
            }
        }
        return result;
    }
}