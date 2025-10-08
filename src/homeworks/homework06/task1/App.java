package homeworks.homework06.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
        List<Product> bag = new ArrayList<>();
        List<Person> persons = new ArrayList<>();

        // добавляет продукты в список
        for (int i = 0; i < 5; i++) {
            System.out.print("nameProduct " + (i + 1) + " : ");
            String nameProduct = scanner.next();

            System.out.print("price " + (i + 1) + " : ");
            int price = scanner.nextInt();
            products.add(new Product(nameProduct,price));

        }

        // добавляет покупателей в список
        for (int i = 0; i < 5; i++) {
            System.out.print("name " + (i + 1) + " : ");
            String name = scanner.next();

            System.out.print("money " + (i + 1) + " : ");
            int money = scanner.nextInt();

            persons.add(new Person(name,money,bag));
        }

        // добавляет продукты в пакет
        for (int i = 0; i < persons.size(); i++) {
            for (int j = 0; j < products.size(); j++) {
                String fullBag = scanner.next();
                if (fullBag.equalsIgnoreCase("END")) {
                    break;
                }
                persons.get(i).addProduct(products.get(j));
            }
            System.out.println(persons.get(i));
        }
    }
}
