package ru.job4j.oop.pojo;

public class Student {
    private String nameSurename;
    private int group;
    private int dateEnter;

    public String getSurName() {
        return nameSurename;
    }

    public void setSurName(String surName) {
        this.nameSurename = surName;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getDateEnter() {
        return dateEnter;
    }

    public void setDateEnter(int dateEnter) {
        this.dateEnter = dateEnter;
    }
}
