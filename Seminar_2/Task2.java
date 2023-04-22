package Seminar_2;

/**
 * Task2
 * Напишите метод, который сжимает строку.
 * Пример: вход aaaabbbcdd.
 */

public class Task2 {

    private static String squizeString(String str) {
        StringBuilder build = new StringBuilder();
        int count = 1;

        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                if (count == 1) {
                    build.append(str.charAt(i));
                } else {
                    build.append(str.charAt(i) + Integer.toString(count));
                    count = 1;
                }
            }
        }
        if (count == 1) {
            build.append(str.substring(str.length() - 1));
        } else {
            build.append(str.substring(str.length() - 1) + Integer.toString(count));
        }
        return build.toString();
    }

    public static void main(String[] args) {
        String str = "aaaabbbcdd";
        System.out.println(squizeString(str));
    }
}
