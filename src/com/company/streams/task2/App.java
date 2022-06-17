package com.company.streams.task2;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        solveTask(userInput());
    }

    private static void solveTask(Integer[] date) {
        Calendar calendar = new GregorianCalendar(date[1], date[0] - 1, 1);
        int i = 1;
        System.out.println("MONDAYS:");
        while (i <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
            calendar.set(Calendar.DAY_OF_MONTH, i);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek == 2) {
                System.out.println(i + "." + date[0] + "." + date[1]);
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
        if (!matcher.find()) {
            System.out.println("Incorrect input. Try again");
            userInput();
        }
        String dateMonth = userInput.substring(0, 2);
        String dateYear = userInput.substring(3);
        if (Integer.parseInt(dateMonth) > 12 || Integer.parseInt(dateMonth) < 1 || Integer.parseInt(dateYear) == 0) {
            System.out.println("Incorrect input. Try again");
            userInput();
        }
        Integer[] date = new Integer[] { Integer.parseInt(dateMonth), Integer.parseInt(dateYear) };
        return date;
    }
}
