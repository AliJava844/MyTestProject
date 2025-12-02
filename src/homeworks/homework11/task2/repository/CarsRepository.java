package homeworks.homework11.task2.repository;

import homeworks.homework11.task2.model.Car;

import java.util.List;

public interface CarsRepository {
    void saveCars(List<Car> cars, String path); // сохранить список в файл
    List<Car> loadCars(String path); // загрузить список из файла
}
