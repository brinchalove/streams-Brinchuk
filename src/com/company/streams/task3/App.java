package com.company.streams.task3;

import java.time.Month;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        solveTask(userInput());
    }

    private static void solveTask(int year) {
        Calendar calendar;
        int i = 0;
        boolean isExist = false;
        while (i < 12) {
            calendar = new GregorianCalendar(year, i, 13);
            if (calendar.get(Calendar.DAY_OF_WEEK) == 6) {
                System.out.println(Month.of(i + 1) + " in " + year + " has Friday 13th.");
                isExist = true;
            }
            i++;
        }
        if(!isExist) {
            System.out.printf("Year %d no have fridays 13th. ", year);
        }
    }

    private static int userInput() {
        System.out.print("Input year: ");
        int year;
        try {
            Scanner scanner = new Scanner(System.in);
            year = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Incorrect value. We set default value as 2022.");
            year = 2022;
        }
        if(year < 1) {
            System.out.println("Incorrect value. We set default value as 2022.");
            year = 2022;
        }
        return year;
    }
}
