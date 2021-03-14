package ru.job4j.io;
import java.util.Scanner;
/**
 * В этом задании вам необходимо сделать игру 11. Смысл игры в следующем. На столе лежат 11 спичек.
 * Два игрока по очереди берут от 1 до 3 спичек. Выигрывает тот, кто забрал последние спички.
 */
public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            if (matches > 0 && matches < 4) {
                System.out.println("На столе осталось спичек: " + (count - matches));
                count -= matches;
                turn = !turn;
            } else {
                System.out.println("Нужно брать от 1 до 3 спичек");
            }
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}
