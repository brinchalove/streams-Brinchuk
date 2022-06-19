package com.company.streams.task1;

import java.time.Month;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        solveTask(userInput());
    }
    private static void solveTask(int year) {
        int i = 0;
            while (i < 12) {
            Calendar calendar = new GregorianCalendar(year, i, 1);
            int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            System.out.printf("Month %s in %d has %d days. %n", Month.of(++i), year, daysInMonth);
        }
    }
    public static Integer userInput() {
        System.out.print("Input year: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Integer userInput = null;
        try {
            userInput = Integer.parseInt(str);
        }catch (NumberFormatException e) {
            throw new NumberFormatException("Incorrect input. ");
        }
        if(userInput < 1) {
            System.out.println("Incorrect value. We set default value as 2022.");
            userInput = 2022;
        }
        return userInput;
    }
}
