package com.company.streams.task1;

import java.time.Month;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int i = 0;
            while (i < 12) {
            Calendar calendar = new GregorianCalendar(year, i, 1);
            int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            System.out.printf("Month %s has %d days. %n", Month.of(++i), daysInMonth);
        }
    }
}
