package com.company.streams.task3;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        solveTask(userInput());
    }

    private static void solveTask(Integer year) {
        int i = 1;
        boolean isExist = false;
        while (i <= 12) {
            LocalDate date = LocalDate.of(year, i, 13);
            if(date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                isExist = true;
                System.out.println(Month.of(i) + " in " + year + " has Friday 13th.");
            }
            i++;
        }
        if(!isExist) {
            System.out.printf("Year %d no have fridays 13th. ", year);
        }
        
    }

    private static Integer userInput() {
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
