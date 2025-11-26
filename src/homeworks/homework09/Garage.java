package homeworks.homework09;

import homeworks.homework09.car.Car;

import java.util.List;
import java.util.Scanner;

public class Garage {
    private List<Car> parkedCars;

    public Garage(List<Car> parkedCars) {
        this.parkedCars = parkedCars;
    }

    public List<Car> getParkedCars() {
        return parkedCars;
    }

    public void setParkedCars(List<Car> parkedCars) {
        this.parkedCars = parkedCars;
    }

    public void park(Car car) {
        parkedCars.add(car);
    }

    public void modifiedCar(int carNumber) {
        Car car = parkedCars.get(carNumber);

        System.out.println(car.toString());

        System.out.println("Выберите какой параметр хотите изменить:");
        Scanner scanner = new Scanner(System.in);

        switch (scanner.nextLine()) {
            case "мощность" -> {
                System.out.print("Введите новое значение мощности: ");
                int newPower = scanner.nextInt();
                car.setPower(newPower);
            } case "подвеска" -> {
                System.out.print("Введите новое значение подвески: ");
                int newSuspension = scanner.nextInt();
                car.setSuspension(newSuspension);
            }

            default -> System.out.println("Выбран не верный параметр");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Garage garage = (Garage) o;
        return parkedCars.equals(garage.parkedCars);
    }

    @Override
    public int hashCode() {
        return parkedCars.hashCode();
    }

    @Override
    public String toString() {
        return "Garage{" +
                "parkedCars=" + parkedCars +
                '}';
    }
}
