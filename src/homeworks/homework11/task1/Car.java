package homeworks.homework11.task1;

public class Car {
    private String numberCar;
    private String model;
    private String color;
    private double mileage;
    private double price;

    public Car(String numberCar, String model, String color, double mileage, double price) {
        this.numberCar = numberCar;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.price = price;
    }

    public String getNumberCar() {
        return numberCar;
    }

    public void setNumberCar(String numberCar) {
        this.numberCar = numberCar;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;
        return Double.compare(mileage, car.mileage) == 0 && Double.compare(price, car.price) == 0 && numberCar.equals(car.numberCar) && model.equals(car.model) && color.equals(car.color);
    }

    @Override
    public int hashCode() {
        int result = numberCar.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + color.hashCode();
        result = 31 * result + Double.hashCode(mileage);
        result = 31 * result + Double.hashCode(price);
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "numberCar='" + numberCar + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                '}';
    }
}
