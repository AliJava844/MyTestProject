package homeworks.homework04;

import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();

        String[] strings = input.split(" ");
        for (int i = 0; i < strings.length; i++) {
            char[] chars = strings[i].toCharArray();
            Arrays.sort(chars);
            strings[i] = new String(chars);
        }

        System.out.println(Arrays.toString(strings));
    }

}
