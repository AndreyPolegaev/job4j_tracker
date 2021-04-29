package ru.job4j.function.streamapi;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

enum Suit {
    Diamonds, Hearts, Spades, Clubs
}

 enum Value {
    V_6, V_7, V_8
}

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
       List<Card> list = Stream.of(Suit.values())
               .flatMap(s -> Stream.of(Value.values())
                       .map(elem -> new Card(s, elem)))
               .collect(Collectors.toList());
       for (Card temp : list) {
           System.out.println(temp.suit + ": " + temp.value);
       }
    }
}
