package homeworks.homework06.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private int money;
    private List<Product> bag;

    public Person(String name, int money, List<Product> bag) {
        this.setName(name);
        this.setMoney(money);
        this.bag = new ArrayList<>();
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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        if (money >= 0) {
            this.money = money;
        } else {
            throw new IllegalArgumentException("Деньги не" +
                    "могут быть отрицательными");
        }
    }

    public List<Product> getBag() {
        return Collections.unmodifiableList(bag);
    }

    public void addProduct(Product product) {
        if (money >= product.getPrice()) {
            bag.add(product);
            money -= product.getPrice();
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
                    ", bag=" + bag +
                    '}';
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;
        return money == person.money && name.equals(person.name) && bag.equals(person.bag);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + money;
        result = 31 * result + bag.hashCode();
        return result;
    }
}
