package Home_Work_1;

import java.util.Scanner;

/*
 * Реализовать простой калькулятор
 */

public class Task3 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Enter the number one: ");
        float n_one = iScanner.nextFloat();
        System.out.println("Enter the operation: ");
        String operation = iScanner.next();
        System.out.println("Enter the number two: ");
        float n_two = iScanner.nextFloat();
        System.out.print("Result: ");
        switch (operation) {
            case "-":
                System.out.println(n_one - n_two);
                break;
            case "+":
                System.out.println(n_one + n_two);
                break;
            case "*":
                System.out.println(n_one * n_two);
                break;
            case "/":
                System.out.println(n_one / n_two);
                break;
            default:
                break;
        }
        iScanner.close();
    }
}
