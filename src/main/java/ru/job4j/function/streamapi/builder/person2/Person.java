package ru.job4j.function.streamapi.builder.person2;

public class Person {
    private String city;
    private String street;
    private int apartment;
    private String name;
    private String surname;
    private int age;
    private boolean marriage;

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMarriage(boolean marriage) {
        this.marriage = marriage;
    }

    @Override
    public String toString() {
        return "Person{"
                + "city='" + city + '\''
                + ", street='" + street + '\''
                + ", apartment=" + apartment
                + ", name='" + name + '\''
                + ", surname='" + surname + '\''
                + ", age=" + age
                + ", marriage=" + marriage
                + '}';
    }
}
