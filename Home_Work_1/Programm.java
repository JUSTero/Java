package Home_Work_1;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * Programm
 */
public class Programm {

    public static void main(String[] args) {
        // System.out.println("Hello World!");
        // System.out.println(LocalDateTime.now());
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("name: ");
        String name = iScanner.nextLine();
        System.out.printf("Привет, %s! \n", name);
        iScanner.close();
    }
}