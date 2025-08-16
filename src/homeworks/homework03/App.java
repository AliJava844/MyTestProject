package homeworks.homework03;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TV tvLG = new TV("LG", 22, 35000, "OLED");
        TV tvSamsung = new TV("Samsung", 24, 38000, "ips");
        TV tvXioami = new TV("Xioami", 20.3, 21000, "ips");

        System.out.println(tvLG);
        System.out.println(tvSamsung);
        System.out.println(tvXioami);

        System.out.print("Модель телевизора: ");
        String model = scanner.nextLine();
        System.out.print("Размер телевизора (дюймы): ");
        int diagonal = scanner.nextInt();
        System.out.print("Цена телевизора: ");
        int price = scanner.nextInt();
        System.out.print("Тип экрана: ");
        String matrix = scanner.next();

        TV tvLenovo = new TV(model, diagonal, price, matrix);
        System.out.println(tvLenovo);

    }
}
