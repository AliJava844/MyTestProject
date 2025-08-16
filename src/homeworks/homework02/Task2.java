package homeworks.homework02;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите 1-е целое число: ");
        int first = scanner.nextInt();
        System.out.print("Введите второе целое число: ");
        int second = scanner.nextInt();

        System.out.println(first + second);
        System.out.println(first - second);
        System.out.println(first * second);
        System.out.println((first + second) / 2.0);
        System.out.println(first - second);
        System.out.println(Math.max(first, second));
        System.out.println(Math.min(first, second));

    }
}
