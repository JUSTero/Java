package Home_Work_1;

import java.util.Scanner;

/**
 * Task1
 * Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение
 * чисел от 1 до n)
 */
public class Task1 {

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = iScanner.nextInt();

        int triangle_n = 1;
        int prod_n = 1;

        for (int i = 2; i <= n; i++) {
            triangle_n += i;
            prod_n *= i;
        }

        iScanner.close();

        System.out.printf("Triangle n = %d, product of n = %d \n", triangle_n, prod_n);
    }
}