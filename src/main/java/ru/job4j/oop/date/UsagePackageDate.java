package ru.job4j.oop.date;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * LocalDate - предназначен для отображения даты (год, месяц, день (yyyy-MM-dd))
 */
public class UsagePackageDate {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println("Current date: " + localDate);
        LocalTime localTime = LocalTime.now();
        System.out.println("Current time: " + localTime);
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current date and time " + currentDateTime);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
        String currentDateTimeFormat = currentDateTime.format(formatter);
        System.out.println("Текущие дата и время после форматирования: " + currentDateTimeFormat);
    }
}
