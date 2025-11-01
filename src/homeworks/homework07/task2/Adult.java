package homeworks.homework07.task2;

import java.util.ArrayList;
import java.util.List;

public class Adult extends Person{
    private List<Product> bag = List.of();
    private boolean credit;

    public Adult(String name, double money, List<Product> bag, int age, boolean credit) {
        super(name, money, bag, age);
        if (age < 18 || age > 65) {
            throw new IllegalArgumentException("Возраст взрослого должен быть от 18 до 65 лет");
        }
        this.credit = credit;
    }

    public boolean isCredit() {
        return credit;
    }

    public void setCredit(boolean credit) {
        this.credit = credit;
    }

    @Override
    public void addProduct(Product product) {
        if (getMoney() >= product.getPrice()) {
            bag = new ArrayList<>(bag);
            bag.add(product);
            setBag(List.copyOf(bag));
            double productPrice = product.getPrice();
            if (product instanceof DiscountProduct) {
                DiscountProduct discountProduct = (DiscountProduct) product;
                if (discountProduct.isDiscountIsOn()) {
                    productPrice = product.getPrice() - (productPrice/ 100 * discountProduct.getDiscount());
                }
            }
            setMoney(getMoney() - productPrice);
            System.out.println(getName() + " купил " + product.getNameProduct());
        } else if (credit) {
            System.out.println(getName() + " купил " + product.getNameProduct() + " в кредит");
        } else {
            System.out.println(getName() + " не может позволить себе " + product.getNameProduct());
        }
    }

    @Override
    public List<Product> getBag() {
        return bag;
    }

    @Override
    public String toString() {
        return "Adult{} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Adult adult = (Adult) o;
        return credit == adult.credit;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Boolean.hashCode(credit);
        return result;
    }
}
