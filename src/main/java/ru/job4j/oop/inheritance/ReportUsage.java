package ru.job4j.oop.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        HtmlReport report = new HtmlReport();
        String text = report.generate("Report's name", "Report's body");
        System.out.println(text);
        JSONReport jsonReport = new JSONReport();
        String text2 = jsonReport.generate("Report's name", "Report's body");
        System.out.println(text2);
    }
}