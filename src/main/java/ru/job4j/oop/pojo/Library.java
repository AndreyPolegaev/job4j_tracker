package ru.job4j.oop.pojo;

public class Library {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        Book headFirstJava = new Book("HeadFirstJava", 400);
        Book javaAlgorithms = new Book("Java Algorithms", 700);
        Book javaPatterns = new Book("Java Patterns", 700);
        Book cleanCode = new Book("Clean Code", 500);
        books[0] = headFirstJava;
        books[1] = javaAlgorithms;
        books[2] = javaPatterns;
        books[3] = cleanCode;
        for (int index = 0; index < books.length; index++) {
            Book temp = books[index];
            System.out.println(temp.getName() + " : " + temp.getPages());
        }
        Book change = books[0];
        books[0] = books[3];
        books[3] = change;
        System.out.println("change-------------------------");
        for (int index = 0; index < books.length; index++) {
            Book temp = books[index];
            System.out.println(temp.getName() + " : " + temp.getPages());
        }
        System.out.println("Show only Clean Code-----------");
        for (int index = 0; index < books.length; index++) {
            Book temp = books[index];
            if (temp.getName().equals("Clean Code")) {
                System.out.println(temp.getName() + " : " + temp.getPages());
            }
        }
    }
}
