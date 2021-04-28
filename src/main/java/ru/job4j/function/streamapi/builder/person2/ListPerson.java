package ru.job4j.function.streamapi.builder.person2;

public class ListPerson {
    public static void main(String[] args) {
        Person firstPerson = new DataPerson()
                .buildAge(30)
                .buildApartment(1)
                .buildCity("Moscow")
                .buildMarriage(true)
                .buildStreet("Lenina")
                .buildName("Vladimir")
                .buildSurname("Ivanov")
                .build();
        System.out.println(firstPerson);
        Person secondPerson = new DataPerson()
                .buildAge(45)
                .buildCity("Moscow")
                .buildMarriage(true)
                .build();
        System.out.println(secondPerson);
    }
}
