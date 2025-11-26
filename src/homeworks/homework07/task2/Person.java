package homeworks.homework07.task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> bag;
    private int age;

    public Person(String name, double money, List<Product> bag, int age) {
        this.setName(name);
        this.setMoney(money);
        this.bag = new ArrayList<>();
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.isEmpty()){
            this.name = name;
        } else {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        if (money >= 0) {
            this.money = money;
        } else {
            throw new IllegalArgumentException("Деньги не" +
                    " могут быть отрицательными");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Возраст не может" +
                    " быть отрицательным");
        }
    }

    public List<Product> getBag() {
        return Collections.unmodifiableList(bag);
    }

    public void setBag(List<Product> bag) {
        this.bag = bag;
    }

    public void addProduct(Product product) {
        if (money >= product.getPrice()) {
            bag.add(product);
            double productPrice = product.getPrice();
            if (product instanceof DiscountProduct) {
                DiscountProduct discountProduct = (DiscountProduct) product;
                if (discountProduct.isDiscountIsOn()) {
                    productPrice = product.getPrice() - (productPrice/ 100 * discountProduct.getDiscount());
                }
            }
            money -= productPrice;
            System.out.println(name + " купил " + product.getNameProduct());
        } else {
            System.out.println(name + " не может позволить себе " + product.getNameProduct());
        }
    }

    @Override
    public String toString() {
        if (bag.isEmpty()) {
            return name + " Ничего не" +
                    " куплено ";
        } else {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", money=" + money +
                    ", bag=" + bag +
                    '}';
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;
        return Double.compare(money, person.money) == 0 && age == person.age && name.equals(person.name) && bag.equals(person.bag);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + Double.hashCode(money);
        result = 31 * result + bag.hashCode();
        result = 31 * result + age;
        return result;
    }
}
