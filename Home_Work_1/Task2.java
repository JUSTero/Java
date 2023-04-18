package Home_Work_1;

/*
 * Вывести все простые числа от 1 до 1000
 */

public class Task2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) {
            System.out.println(i);
        }
        for (int i = 4; i <= 1000; i++) {
            boolean flag = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) System.out.println(i);
        }
    }
}
