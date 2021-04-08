package ru.job4j.oop.college;

public class College {
    public static void main(String[] args) {
        Freshman freshman = new Freshman();
        Student student = freshman;
        Student student1 = new Freshman();
        Object obj = freshman;
    }
}
