package com.company.streams.task2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        printMondaysDate(getMondaysDate(getUserInput()));
    }

    private static void printMondaysDate(List<LocalDate> list) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        list.forEach(d -> System.out.println(dtf.format(d)));
    }

    private static List<LocalDate> getMondaysDate(HashMap<Integer, Integer> map) {
        Optional<Integer> year = map.values().stream().findFirst();
        Optional<Integer> month = map.keySet().stream().findFirst();
        LocalDate date = LocalDate.of(year.get(), month.get(), 1);
        int i = 1;

        System.out.println("MONDAYS:");
        List<LocalDate> list = new ArrayList<>();
        while (i <= (date.lengthOfMonth())) {
            date = LocalDate.of(date.getYear(), date.getMonth(), i);
            if (date.getDayOfWeek() == DayOfWeek.MONDAY) {
                list.add(date);

            }
            i++;
        }
        return list;
    }

    public static HashMap<Integer, Integer> getUserInput() {
        System.out.print("Write date type of MM-YYYY: ");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        userInput = userInput.trim();
        Pattern pattern = Pattern.compile("^\\d{2}-\\d{4}$");
        Matcher matcher = pattern.matcher(userInput);
        Integer[] date = new Integer[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        if (!matcher.find()) {
            System.out.println("Incorrect input. We set default value as 06-2022.");
            map.put(6, 2022);
            date[0] = 06;
            date[1] = 2022;
            return map;
        }
        try {
            String dateMonth = userInput.substring(0, 2);
            String dateYear = userInput.substring(3);
            if (Integer.parseInt(dateMonth) > 12 || Integer.parseInt(dateMonth) < 1
                    || Integer.parseInt(dateYear) == 0) {
                System.out.println("Incorrect input. We set default value as 06-2022.");
                map.put(6, 2022);
                date[0] = 06;
                date[1] = 2022;
                return map;
            }
            date = new Integer[] { Integer.parseInt(dateMonth), Integer.parseInt(dateYear) };
            map.put(Integer.parseInt(dateMonth), Integer.parseInt(dateYear));
        } catch (StringIndexOutOfBoundsException | NumberFormatException e) {
            throw new RuntimeException("Incorrect input. ");
        }
        return map;
    }
}
