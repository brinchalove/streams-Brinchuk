package com.company.streams.task2;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
//        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
//        String formattedTime = formatter.format(LocalDateTime.now());
//        System.out.println(formattedTime);

        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt() - 1;
        Calendar calendar = new GregorianCalendar(year, month, 1);
        int i = 1;
        while (i <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
            calendar.set(Calendar.DAY_OF_MONTH, i);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek == 2) {
                System.out.println(i + "." + (month + 1) + "." + year);
            }
            i++;
        }

    }
}
