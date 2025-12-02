package homeworks.homework09.car;

public class ShowCar extends Car{
    private int stars;

    public ShowCar(String brand, String model, int yearOfManufacture, int power, int acceleration, int suspension, int durability, int stars) {
        super(brand, model, yearOfManufacture, power, acceleration, suspension, durability);
        this.stars = stars;
    }

    public ShowCar() {
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ShowCar showCar = (ShowCar) o;
        return stars == showCar.stars;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + stars;
        return result;
    }

    @Override
    public String toString() {
        return "ShowCar{" +
                "stars=" + stars +
                "} " + super.toString();
    }
}
