package homeworks.homework07.task2;

import java.util.List;

public class Child extends Person{
    public Child(String name, double money, List<Product> bag, int age) {
        super(name, money, bag, age);
    }

    @Override
    public void addProduct(Product product) {
        if (getAge() >= 6 && getAge() <= 17) {
            if (product.isAvailability()) {
                super.addProduct(product);
            } else {
                System.out.println("Продукт " + product.getNameProduct() + " нельзя покупать " +
                        getName() + " потому-что он еще несовершеннолетний");
            }
        } else if (getAge() < 6 && getAge() >= 0) {
            System.out.println(getName() + " слишком мал для покупок");
        }
    }

    @Override
    public String toString() {
        return "Child{} " + super.toString();
    }
}
