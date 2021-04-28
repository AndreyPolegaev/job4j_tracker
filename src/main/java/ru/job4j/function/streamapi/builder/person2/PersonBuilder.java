package ru.job4j.function.streamapi.builder.person2;

public interface PersonBuilder {

    PersonBuilder buildCity(String city);

    PersonBuilder buildStreet(String street);

    PersonBuilder buildApartment(int apartment);

    PersonBuilder buildName(String name);

    PersonBuilder buildSurname(String surname);

    PersonBuilder buildAge(int age);

    PersonBuilder buildMarriage(boolean marriage);

    Person build();

}
