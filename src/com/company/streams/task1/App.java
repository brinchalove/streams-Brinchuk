package com.company.streams.task1;

import java.time.Year;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        solveTask(userInput());
    }
    private static void solveTask(Integer userInputYear) {
        Year year = Year.parse(userInputYear.toString());
        int i = 1;
        while (i <= 12) {
            System.out.printf("Month %s in %d has %d days. %n", year.atMonth(i).getMonth(), userInputYear, year.atMonth(i++).lengthOfMonth());
        }
    }
    private static Integer userInput() {
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
