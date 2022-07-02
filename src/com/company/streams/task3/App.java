package com.company.streams.task3;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        printMonthsWithFridays13h(getMonthsWithFridays13h(getUserInput()));
    }

    private static void printMonthsWithFridays13h(List<Integer> list) {
        list.forEach(m -> System.out.println(Month.of(m) + " has Friday 13th."));
    }

    private static List<Integer> getMonthsWithFridays13h(Integer year) {
        int i = 1;
        boolean isExist = false;
        List<Integer> list = new ArrayList<>();
        while (i <= Month.values().length) {
            LocalDate date = LocalDate.of(year, i, 13);
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                isExist = true;
                list.add(i);
            }
            i++;
        }
        if (!isExist) {
            System.out.printf("Year %d no have fridays 13th. ", year);
        }
        return list;
    }

    private static Integer getUserInput() {
        System.out.print("Input year: ");
        int year;
        try {
            Scanner scanner = new Scanner(System.in);
            year = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Incorrect value. We set default value as 2022.");
            year = 2022;
        }
        if (year < 1) {
            System.out.println("Incorrect value. We set default value as 2022.");
            year = 2022;
        }
        return year;
    }
}
