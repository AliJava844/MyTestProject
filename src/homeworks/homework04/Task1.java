package homeworks.homework04;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        String string = "qwertyuipasdfghjklzxcvbnm";

        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        if (string.indexOf(input) == 0) {
            System.out.println(string.charAt(string.length() - 1));
        } else {
            System.out.println(string.charAt(string.indexOf(input) - 1));
        }

    }

}
