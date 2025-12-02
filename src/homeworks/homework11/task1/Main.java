package homeworks.homework11.task1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("a123me", "Mercedes", "White", 0, 8300000));
        cars.add(new Car("b873of", "Volga", "Black", 0, 673000));
        cars.add(new Car("w487mn", "Lexus", "Grey", 76000, 900000));
        cars.add(new Car("p987hj", "Volga", "Red", 610, 704340));
        cars.add(new Car("c987ss", "Toyota", "White", 254000, 761000));
        cars.add(new Car("o983op", "Toyota", "Black", 698000, 740000));
        cars.add(new Car("p146op", "BMW", "White", 271000, 850000));
        cars.add(new Car("u893ii", "Toyota", "Purple", 210900, 440000));
        cars.add(new Car("l097df", "Toyota", "Black", 108000, 780000));
        cars.add(new Car("y876wd", "Toyota", "Black", 160000, 1000000));

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
    }
}
