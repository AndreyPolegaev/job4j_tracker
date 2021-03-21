package ru.job4j.ex;
/* Без базового условия получим StackOverflowError.*/
public class FactRec {
    public static int calc(int n) {
        if (n < 2) {
            return 1;
        }
        return n * calc(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(calc(5));
    }
}
