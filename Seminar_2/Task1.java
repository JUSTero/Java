package Seminar_2;

import java.util.Scanner;

/**
 * Task1
 * Дано четное число N (>0) и символы c1 и c2.
 * Написать метод, который вернет строку длины N, которая состоит из
 * чередующихся символов c1 и c2, начиная с c1.
 */

public class Task1 {

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Enter N: ");
        int N = iScanner.nextInt();
        System.out.println("Enter C1: ");
        String C1 = iScanner.next();
        System.out.println("Enter C2: ");
        String C2 = iScanner.next();
        iScanner.close();
        String Result = "";

        for (int i = 0; i < N / 2; i++) {
            Result = Result + C1 + C2;
        }

        System.out.printf("Result: %s \n", Result);
    }
}
