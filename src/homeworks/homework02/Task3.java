package homeworks.homework02;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Исходная строка: ");
        String inputString = scanner.next();
        System.out.print("Сколько раз вывести строку: ");

        int count = scanner.nextInt();
        String result = "";

        for (int i = 0; i < count; i++) {
            result = result + inputString;
        }

        System.out.println("После повторения " + count + " раз: " + result);

    }
}
