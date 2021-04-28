package ru.job4j.function.streamapi.builder.person2;

public class DataPerson implements PersonBuilder {

    private Person person = new Person();

    @Override
    public PersonBuilder buildCity(String city) {
        person.setCity(city);
        return this;
    }

    @Override
    public PersonBuilder buildStreet(String street) {
        person.setStreet(street);
        return this;
    }

    @Override
    public PersonBuilder buildApartment(int apartment) {
        person.setApartment(apartment);
        return this;
    }

    @Override
    public PersonBuilder buildName(String name) {
        person.setName(name);
        return this;
    }

    @Override
    public PersonBuilder buildSurname(String surname) {
        person.setSurname(surname);
        return this;
    }

    @Override
    public PersonBuilder buildAge(int age) {
        person.setAge(age);
        return this;
    }

    @Override
    public PersonBuilder buildMarriage(boolean marriage) {
        person.setMarriage(marriage);
        return this;
    }

    @Override
    public Person build() {
        return person;
    }
}
