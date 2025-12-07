package homeworks.homework11.task2.test;

import homeworks.homework11.task2.model.Car;
import homeworks.homework11.task2.repository.CarsRepository;
import homeworks.homework11.task2.repository.CarsRepositoryImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        CarsRepository repo = new CarsRepositoryImpl();

        // Загрузим автомобили из файла carsInput.txt
        String filePath = "src/homeworks/homework11/task2/data/carsInput.txt";
        List<Car> cars = repo.loadCars(filePath);

        // Вывод исходного списка (для наглядности)
        System.out.println("--- Весь список автомобилей ---");
        cars.forEach(System.out::println);
        System.out.println();

        // 4. Использование Java Stream API

        // --- Задание 1 ---
        // Номера всех автомобилей: цвет colorToFind ИЛИ нулевой пробег.
        String colorToFind = "Black";
        double mileageToFind = 0;
        System.out.println("1) Номера авто (Цвет " + colorToFind + " или пробег " + mileageToFind + "):");
        List<String> numbers = cars.stream()
                .filter(car -> car.getColor().equalsIgnoreCase(colorToFind) || car.getMileage() == mileageToFind)
                .map(Car::getNumberCar) // Берем только номера
                .collect(Collectors.toList());

        System.out.println(numbers);
        System.out.println("-------------------------");

        // --- Задание 2 ---
        // Количество уникальных моделей в ценовом диапазоне от n до m тыс.
        double minPrice = 700000;
        double maxPrice = 800000;

        long uniqueModelsCount = cars.stream()
                .filter(car -> car.getPrice() >= minPrice && car.getPrice() <= maxPrice)
                .map(Car::getModel)
                .distinct() // Оставляем только уникальные названия
                .count();

        System.out.println("2) Уникальных моделей в цене от " + minPrice + " до " + maxPrice + ":");
        System.out.println(uniqueModelsCount);
        System.out.println("-------------------------");

        // --- Задание 3 ---
        // Вывести цвет автомобиля с минимальной стоимостью.
        System.out.println("3) Цвет автомобиля с минимальной стоимостью:");

        String cheapestCarColor = cars.stream()
                .min(Comparator.comparingDouble(Car::getPrice)) // Находим авто с мин. ценой
                .map(Car::getColor) // Получаем его цвет
                .orElse("Список пуст"); // Если список был пустой

        System.out.println(cheapestCarColor);
        System.out.println("-------------------------");

        // --- Задание 4 ---
        // Средняя стоимость искомой модели modelToFind.
        String modelToFind = "Toyota";
        System.out.println("4) Средняя стоимость модели " + modelToFind + ":");

        cars.stream()
                .filter(car -> car.getModel().equalsIgnoreCase(modelToFind))
                .mapToDouble(Car::getPrice) // Преобразуем в поток double
                .average() // Считаем среднее
                .ifPresentOrElse(
                         System.out::println,
                        () -> System.out.println("Модель не найдена")
                );

        String filePathOutput = "src/homeworks/homework11/task2/data/carsOutput.txt";
        repo.saveCars(cars, filePathOutput);
    }
}
