package homeworks.homework09.car;

import java.util.Arrays;

public class PerformanceCar extends Car{
    private String[] addOns;

    public PerformanceCar(String brand, String model, int yearOfManufacture, int power, int acceleration, int suspension, int durability, String[] addOns) {
        super(brand, model, yearOfManufacture, (int) (power * 1.5), acceleration, (int) (suspension * 0.75), durability);
        this.addOns = addOns;
    }

    public PerformanceCar() {
    }

    @Override
    public void setPower(int power) {
        super.setPower((int) (power * 1.5));
    }

    @Override
    public void setSuspension(int suspension) {
        super.setSuspension((int) (suspension * 0.75));
    }

    public String[] getAddOns() {
        return addOns;
    }

    public void setAddOns(String[] addOns) {
        this.addOns = addOns;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PerformanceCar that = (PerformanceCar) o;
        return Arrays.equals(addOns, that.addOns);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(addOns);
        return result;
    }

    @Override
    public String toString() {
        return "PerformanceCar{" +
                "addOns=" + Arrays.toString(addOns) +
                "} " + super.toString();
    }
}
