package ru.job4j.oop.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setSurName("Petr Arsentiev");
        student.setGroup(1);
        student.setDateEnter(2004);
        System.out.println("ФИО " + student.getSurName() + ", Группа " + student.getGroup()
                           + ", Дата Поступления " + student.getDateEnter());
    }
}
