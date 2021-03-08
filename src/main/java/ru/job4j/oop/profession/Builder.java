package ru.job4j.oop.profession;

public class Builder extends Engineer {
    private String skills;

    public void info() {
        System.out.println("Hello Im a builder i can offer a next service" + this.skills);
    }
}
