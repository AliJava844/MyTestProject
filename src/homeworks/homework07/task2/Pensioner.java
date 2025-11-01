package homeworks.homework07.task2;

import java.util.ArrayList;
import java.util.List;

public class Pensioner extends Person {
    private List<Product> bag = List.of();

    public Pensioner(String name, double money, List<Product> bag, int age) {
        super(name, money, bag, age);
        if (age < 65) {
            throw new IllegalArgumentException("Минимальный возраст пенсионера 65");
        }
    }

    @Override
    public void addProduct(Product product) {
        if (getMoney() >= product.getPrice()) {
            double productPrice = product.getPrice();
            if (product instanceof DiscountProduct) {
                DiscountProduct discountProduct = (DiscountProduct) product;
                bag = new ArrayList<>(bag);
                bag.add(discountProduct);
                setBag(List.copyOf(bag));
                if (discountProduct.isDiscountIsOn()) {
                    discountProduct.setDiscount(discountProduct.getDiscount() + 5);
                    productPrice = product.getPrice() - (productPrice/ 100 * discountProduct.getDiscount());
                }
            } else {
                throw new IllegalArgumentException("Пенсионеры не покупают продукты без скидки");
            }
            setMoney(getMoney() - productPrice);
            System.out.println(getName() + " купил " + product.getNameProduct());
        } else {
            System.out.println(getName() + " не может позволить себе " + product.getNameProduct());
        }
    }

    @Override
    public String toString() {
        return "Pensioner{} " + super.toString();
    }
}
