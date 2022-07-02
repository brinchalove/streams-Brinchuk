package com.company.streams.task1;

import java.time.Month;
import java.time.Year;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        printDaysOfMonthInYear(getDaysOfMonthInYear(getUserInput()));
    }

    private static void printDaysOfMonthInYear(HashMap<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.printf("%s has %d days. %n", Month.of(entry.getKey()), entry.getValue());
        }
    }

    private static HashMap<Integer, Integer> getDaysOfMonthInYear(Integer userInputYear) {
        Year year = Year.parse(userInputYear.toString());
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 1;
        while (i <= 12) {
            map.put(i, year.atMonth(i++).lengthOfMonth());
        }
        return map;
    }

    private static Integer getUserInput() {
        System.out.print("Input year: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Integer userInput = null;
        try {
            userInput = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Incorrect input. ");
        }
        if (userInput < 1) {
            System.out.println("Incorrect value. We set default value as 2022.");
            userInput = 2022;
        }
        return userInput;
    }
}
