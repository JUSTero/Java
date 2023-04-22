package Home_Work_2;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Task2
 * Реализуйте алгоритм сортировки пузырьком числового массива, результат после
 * каждой итерации запишите в лог-файл.
 */

public class Task2 {
    public static class BubbleSort {
        private static final Logger logger = Logger.getLogger(BubbleSort.class.getName());

        public static void main(String[] args) {
            int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
            logger.setLevel(Level.INFO);
            logger.info("Исходный массив: " + Arrays.toString(arr));
            bubbleSort(arr);
            logger.info("Отсортированный массив: " + Arrays.toString(arr));
        }

        public static void bubbleSort(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
                logger.info("Промежуточный результат на " + (i + 1) + "-й итерации: " + Arrays.toString(arr));
            }
        }
    }
}