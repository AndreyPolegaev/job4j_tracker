package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hare = new Hare();
        Wolff wolff = new Wolff();
        Fox fox = new Fox();
        ball.tryEat(ball);
        hare.tryEat(ball);
        wolff.tryEat(ball);
        fox.tryEat(ball);
    }
}
