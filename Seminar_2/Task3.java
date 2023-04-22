package Seminar_2;

import java.util.Scanner;

/**
 * Task3
 * Напишите метод, который принимает на вход строку (String) и определяет
 * является ли строка палиндромом (возвращает boolean значение).
 */
public class Task3 {

    public static boolean checkPalindrom(String str) {

        str = str.toLowerCase().replace(" ", "");
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
        if (str.charAt(i) != str.charAt(len - 1 - i)) {
        return false;
        }
        
        }
        return true;
        }
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String string = iScanner.next();
        iScanner.close();

        System.out.printf("Palindrom is %s", checkPalindrom(string));
    }
}