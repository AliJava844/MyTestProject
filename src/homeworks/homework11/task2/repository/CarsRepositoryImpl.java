package homeworks.homework11.task2.repository;

import homeworks.homework11.task2.model.Car;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CarsRepositoryImpl implements CarsRepository {

    @Override
    public void saveCars(List<Car> cars, String path) {
        try(PrintWriter writer = new PrintWriter(new FileWriter(path))) {
            for (Car car: cars) {
                writer.println(car);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Car> loadCars(String path) {
        List<Car> cars = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                cars.add(Car.fromString(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cars;
    }
}
