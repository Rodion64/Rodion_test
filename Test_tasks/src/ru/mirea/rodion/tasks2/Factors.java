package ru.mirea.rodion.tasks2;

import java.util.Scanner;

public class Factors {

    public static void findFactors(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое число, которое нужно разделить на простые множители");

        int n = scanner.nextInt();
        int m = 2;

        while (n !=1) {
            if (n % m == 0){
                System.out.println(m + "  ");
                n /= m;
            } else if (m == 2){
                m++;
            } else {
                m += 2;
            }
        }
    }
}