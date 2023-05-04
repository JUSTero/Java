package Home_Work_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    public static <T> List<T> reverseList(List<T> list) {
        List<T> reverse = new ArrayList<>(list);
        Collections.reverse(reverse);
        return reverse;
    }

    public static void main(String[] args) {
        ArrayList aList = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        String srtFromCons;
        System.out.println(
                "Введите значение для строки.\nДля вывода перевернутого спискаиспользуйте 'print'\nДля удаления последнего введенного элемента используйте 'revert'\nДля выхода используйте 'exit'");

        while (!(srtFromCons = scanner.nextLine()).equals("exit")) {
            switch (srtFromCons) {
                case "print":
                    System.out.println("Получился перевёрнутый LinkedList: " + reverseList(aList));
                    break;
                case "revert":
                    aList.remove(aList.size() - 1);
                    break;

                default:
                    aList.add(srtFromCons);
                    break;
            }
        }
        scanner.close();

    }
}
