package com.company.streams.task3;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();

        Calendar calendar;
        int i = 0;
        while (i < 12) {
            calendar = new GregorianCalendar(year, i, 13);
            if (calendar.get(Calendar.DAY_OF_WEEK) == 6) {
                System.out.println("123 " + i);
                
            }i++;
        }
    }
}
