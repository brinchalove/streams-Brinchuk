package com.company.streams.task2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        solveTask(userInput());
    }

    private static void solveTask(Integer[] userInputDate) {
        LocalDate date = LocalDate.of(userInputDate[1], userInputDate[0], 1);
        int i = 1;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.println("MONDAYS:");
        while (i <= Month.of(userInputDate[0]).maxLength()) {
            date = LocalDate.of(userInputDate[1], userInputDate[0], i);
            if (date.getDayOfWeek() == DayOfWeek.MONDAY) {
                String formattedDate = dtf.format(date);
                System.out.println(formattedDate);
            }
            i++;
        }
    }

    public static Integer[] userInput() {
        System.out.print("Write date type of MM-YYYY: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        userInput = userInput.trim();
        Pattern pattern = Pattern.compile("^\\d{2}-\\d{4}$");
        Matcher matcher = pattern.matcher(userInput);
        Integer[] date = new Integer[2];
        if (!matcher.find()) {
            System.out.println("Incorrect input. We set default value as 06-2022.");
            date[0] = 06;
            date[1] = 2022;
            return date;
        }
        try {
            String dateMonth = userInput.substring(0, 2);
            String dateYear = userInput.substring(3);
            if (Integer.parseInt(dateMonth) > 12 || Integer.parseInt(dateMonth) < 1
                    || Integer.parseInt(dateYear) == 0) {
                System.out.println("Incorrect input. We set default value as 06-2022.");
                date[0] = 06;
                date[1] = 2022;
                return date;
            }
            date = new Integer[] { Integer.parseInt(dateMonth), Integer.parseInt(dateYear) };
        } catch (StringIndexOutOfBoundsException | NumberFormatException e) {
            throw new RuntimeException("Incorrect input. ");
        }
        return date;
    }
}
