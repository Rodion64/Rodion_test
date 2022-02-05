package ru.mirea.rodion.tasks1;

import java.util.Scanner;

public class Sum {


    public static void calculator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введит любую строку");

        String input = scanner.next();

        int sum = 0;

        char[] arr = input.toCharArray();

        for (int i = 0; i <= arr.length - 1; i++) {
            if (Character.isDigit(arr[i])) {
                char arr1 = arr[i];
                String s = Character.toString(arr1);
                int k = Integer.parseInt(s);

                sum += k;
            }
        }
        System.out.println(sum);
    }
}


