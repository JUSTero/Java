package Seminar_2;

import java.util.Scanner;

/**
 * Task1
 * Дано четное число N (>0) и символы c1 и c2.
 * Написать метод, который вернет строку длины N, которая состоит из
 * чередующихся символов c1 и c2, начиная с c1.
 */

public class Task1 {
    private static String GenerateString(int N, char C1, char C2) {
        StringBuilder Result = new StringBuilder();
        for (int i = 0; i < N / 2; i++) {
            Result.append(String.format("%c%c", C1, C2));
        }
        return Result.toString();
    }

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Enter N: ");
        int N = iScanner.nextInt();
        System.out.println("Enter C1: ");
        char C1 = iScanner.next().charAt(0);
        System.out.println("Enter C2: ");
        char C2 = iScanner.next().charAt(0);
        iScanner.close();

        System.out.printf("Result: %s", GenerateString(N, C1, C2));
    }
}
