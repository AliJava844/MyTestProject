package homeworks.homework07.task2;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Product coffee = new Product("coffee", 102, false);
        Product milk = new Product("milk", 80, true);
        DiscountProduct meat = new DiscountProduct("meat", 135, true, 20, true, LocalDate.of(2025, 10, 25));
        List<Product> bag = new ArrayList<>();

        Person ali = new Person("Ali",500, bag, 34);
        Child ahmed = new Child("Ahmed", 350, bag, 8);
        Child ibrahim = new Child("Ibrahim", 240, bag, 3);
        Adult jon = new Adult("Jon",200, bag, 45, true);
        Pensioner mike = new Pensioner("Mike",500, bag, 68);

        ali.addProduct(coffee);
        ali.addProduct(milk);
        ali.addProduct(meat);

        ahmed.addProduct(coffee);
        ahmed.addProduct(milk);
        ahmed.addProduct(meat);

        ibrahim.addProduct(coffee);
        ibrahim.addProduct(milk);
        ibrahim.addProduct(meat);

        jon.addProduct(coffee);
        jon.addProduct(milk);
        jon.addProduct(meat);

        //mike.addProduct(milk);
        mike.addProduct(meat);


        System.out.println(ali);
        System.out.println(ahmed);
        System.out.println(ibrahim);
        System.out.println(jon);
        System.out.println(mike);
    }
}
