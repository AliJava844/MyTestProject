package homeworks.homework07.task1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Product coffee = new Product("Coffee", 102);
        DiscountProduct milk = new DiscountProduct("Milk", 80, 20, true, LocalDate.of(2025,10, 14));
        DiscountProduct meat = new DiscountProduct("Meat", 100, 5, true, LocalDate.of(2025,10, 21));
        DiscountProduct bread = new DiscountProduct("Bread", 57, 5, true, LocalDate.of(2025, 10, 11));
        List<Product> bag = new ArrayList<>();

        Person person = new Person("Ibrahim", 1000, bag);

        person.addProduct(coffee);
        person.addProduct(milk);
        person.addProduct(meat);
        person.addProduct(bread);

        System.out.println(person);
    }
}
