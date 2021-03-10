package ru.job4j.oop.pojo;

public class Book {
    private String name;
    private int pages;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Book(String name, int pages) {
        this.name = name;
        this.pages = pages;
    }
}
