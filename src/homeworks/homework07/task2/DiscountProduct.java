package homeworks.homework07.task2;

import java.time.LocalDate;

public class DiscountProduct extends Product {
    private int discount;
    private boolean discountIsOn;
    private LocalDate timeDiscount;

    public DiscountProduct(String nameProduct, double price, boolean availability, int discount, boolean discountIsOn, LocalDate timeDiscount) {
        super(nameProduct, price, availability);
        this.discount = discount;
        this.discountIsOn = discountIsOn;
        this.timeDiscount = timeDiscount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public boolean isDiscountIsOn() {
        LocalDate today = LocalDate.now();
        if (today.isAfter(timeDiscount)) {
            reduceDiscountAfter();
        }
        return discountIsOn;
    }

    public void setDiscountIsOn(boolean discountIsOn) {
        this.discountIsOn = discountIsOn;
    }

    public LocalDate getTimeDiscount() {
        return timeDiscount;
    }

    public void setTimeDiscount(LocalDate timeDiscount) {
        this.timeDiscount = timeDiscount;
    }

    private void reduceDiscountAfter() {
        if (discount > 5) {
            discount -= 5;
            System.out.println("Срок действия скидки истек. Новая скидка на" +
                    getNameProduct() + ": " + discount + "%");
        } else {
            discount = 0;
            discountIsOn = false;
            System.out.println("Скидка на " + getNameProduct() + " полностью истекла и больше не " +
                    "действует.");
        }
    }

    @Override
    public String toString() {
        return "DiscountProduct{" +
                "discount=" + discount +
                ", discountIsOn=" + discountIsOn +
                ", timeDiscount=" + timeDiscount +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        DiscountProduct that = (DiscountProduct) o;
        return discount == that.discount && discountIsOn == that.discountIsOn && timeDiscount.equals(that.timeDiscount);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + discount;
        result = 31 * result + Boolean.hashCode(discountIsOn);
        result = 31 * result + timeDiscount.hashCode();
        return result;
    }
}
