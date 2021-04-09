package ru.myenum;

public enum Season {
    WINTER(-30), SPRING(10), SUMMER(25), AUTUMN(15);

    private int value;

    Season(int value) {
        this.value = value;
    }

    public int info() {
        return value;
    }
}












