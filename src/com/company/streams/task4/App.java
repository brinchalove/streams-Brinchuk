package com.company.streams.task4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        String filename = "resources/text.txt";
        System.out.printf("There are %d words in text. %n", getWordsNumber(getListOfWords(filename)));
        System.out.printf("%.2f is average word length in text. %n", wordsAverageLength(getListOfWords(filename)));
        System.out.printf("There are %d these words in text. %n", isExist(getListOfWords(filename)));
        contains(getListOfWords(filename));
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.printf("Sorted list. %s",sort(getListOfWords(filename)));
    }
    
    private static List<String> sort(List<String> list) {
        list.sort(new MyStringCoparator());
        return list;
    }

    private static Long isExist(List<String> list) {
        System.out.print("Input first letter of word what you want to find: ");
        Scanner scanner = new Scanner(System.in);
        char symbol = scanner.next().charAt(0);
        System.out.print("Input max word legth: ");
        int maxWordLength = scanner.nextInt();
        long wordsCounter = list.stream().filter(w -> w.charAt(0) == symbol).filter(w -> w.length() < maxWordLength)
                .count();
        return wordsCounter;
    }

    private static boolean contains(List<String> list) {
        boolean isContain = false;
        System.out.print("What word would you find in text? ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Optional<String> optName = list.stream()//
                .filter(w -> w.equals(input))//
                .findFirst();//
        if (optName.isPresent()) {
            System.out.println("Word is exist.");
            isContain = true;
        } else {
            System.out.println("No such word.");
            isContain = false;
        }
        return isContain;
    }

    private static long getWordsNumber(List<String> list) {
        return list.size();
    }

    private static double wordsAverageLength(List<String> list) {
        double letters = 0;
        for (String word : list) {
            letters += word.length();
        }
        return letters / getWordsNumber(list);

    }

    private static List<String> getListOfWords(String filename) {
        String str = new String(getContent(filename));
        Pattern pattern = Pattern.compile("[A-Za-z]+([-]?[A-Za-z]*)+[!.,:;\\s ]*");
        Matcher matcher = pattern.matcher(str);
        List<String> list = new ArrayList<>();
        String str2 = "";
        while (matcher.find()) {
            str2 = str.substring(matcher.start(), matcher.end());
            str2 = str2.replaceAll("[!.,:;\\s ]", "");
            list.add(str2);
        }
        return list;
    }

    public static StringBuilder getContent(String filename) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append('\n');
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
