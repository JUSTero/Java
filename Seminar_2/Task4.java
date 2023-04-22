package Seminar_2;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Task4
 * Напишите метод, который составит строку, состоящую из 100 повторений слова
 * TEST и метод, который запишет эту строку в простой текстовый файл,
 * обработайте исключения.
 */

public class Task4 {
    private static String GenerateString() {
        StringBuilder Result = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            Result.append(String.format("TEST\n"));
        }
        return Result.toString();
    }

    private static void WriteInFile(String str) {
        try (FileWriter writer = new FileWriter("TEST.txt", false)) {
            writer.write(str);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        WriteInFile(GenerateString());
    }
}