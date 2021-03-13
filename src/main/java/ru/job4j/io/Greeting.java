package ru.job4j.io;
import java.util.Scanner;

public class Greeting {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("как вас зовут?");
        String name = input.next();
        System.out.println("привет " + name);
    }
}
