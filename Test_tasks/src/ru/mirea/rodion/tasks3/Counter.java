package ru.mirea.rodion.tasks3;

import java.util.Arrays;
import java.util.Scanner;

public class Counter {

    public void workString() {
        Scanner strInput = new Scanner(System.in);
        System.out.println("Введите случайное предложение русскими буквами");
        String userInput = strInput.nextLine();

        userInput = userInput.trim();
        userInput = userInput.toLowerCase();
        String userWords[] = userInput.split(" ");


        for (int j = 0; j < userWords.length - 1; j++) {
            for (int i = j + 1; i < userWords.length; i++) {
                if (userWords[i].compareToIgnoreCase(userWords[j]) < 0) {
                    String temp = userWords[j];
                    userWords[j] = userWords[i];
                    userWords[i] = temp;
                }
            }
        }

        for (int i = 0; i < userWords.length; i++) {
            System.out.print(userWords[i] + "  ");
        }
        System.out.println();
        System.out.println();

        String vowel = "аеёиоуыэюя";

        for (int i = 0; i < userWords.length; i++) {
            for (int j = 0; j < userWords[i].length(); j++) {
                int index = vowel.indexOf(userWords[i].charAt(j));
            }
        }

        int[] count = new int[userWords.length];

        for (int i = 0; i < userWords.length; i++) {
            for (int j = 0; j < userWords[i].length(); j++) {
                int index = vowel.indexOf(userWords[i].charAt(j));
                if (index >= 0) {
                    count[i] = count[i] + 1;
                }
            }
        }

        System.out.println("Количество гласных в словах:");
        for (int i = 0; i < count.length; i++) {
            System.out.print(count[i] + " ");
        }
        System.out.println();


        for (int i = 0; i < count.length - 1; i++) {
            for (int j = i + 1; j < count.length; j++) {
                if (count[i] < count[j]) {

                    int bufer = count[i];
                    count[i] = count[j];
                    count[j] = bufer;

                    String strBufer = userWords[i];
                    userWords[i] = userWords[j];
                    userWords[j] = strBufer;
                }
            }
        }

        System.out.println();
        System.out.println("Отсортированы числа и слова:");
        System.out.println(Arrays.toString(count));
        System.out.println(Arrays.toString(userWords));

        System.out.println();
        System.out.println("Делаем первую гласную букву в слове заглавной: ");

        int index;
        int[] indexOfFirstVowelsInAWord = new int[userWords.length];
        for (int i = 0; i < userWords.length; i++) {
            for (int j = 0; j < userWords[i].length(); j++) {
                if ("АаЕеЁёИиОоУуЫыЭэЮюЯя".indexOf(userWords[i].charAt(j)) > -1) {
                    index = j;
                    indexOfFirstVowelsInAWord[i] = index;
                    break;
                }
            }
        }

        int[] indexOfFirstVowel = indexOfFirstVowelsInAWord;
        for (int i = 0; i < userWords.length; i++) {
            System.out.print(userWords[i].substring(0, indexOfFirstVowel[i]) +
                    userWords[i].substring(indexOfFirstVowel[i], indexOfFirstVowel[i] + 1).toUpperCase() +
                    userWords[i].substring(indexOfFirstVowel[i] + 1, userWords[i].length()) + " ");
        }
    }
}