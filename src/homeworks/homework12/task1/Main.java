package homeworks.homework12.task1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные (Фамилия Имя Отчество ДатаРождения(dd.mm.yyyy) Телефон Пол(f/m) Возраст) через пробел:");

        try {
            String input = scanner.nextLine();
            // 1. Проверяем данные и парсим их
            Person person = parseStringData(input);

            // 2. Если всё ок, записываем в файл
            writeFile(person);

            System.out.println("Данные успешно записаны в файл: " + person.surname + ".txt");

        } catch (InvalidDataCountException e) {
            System.err.println("Ошибка количества данных: " + e.getMessage());
        } catch (BadDataFormatException e) {
            System.err.println("Ошибка формата данных: " + e.getMessage());
        } catch (IOException e) {
            // 6. Стектрейс для ошибок ввода-вывода (файловой системы)
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static Person parseStringData(String input) throws InvalidDataCountException, BadDataFormatException {
        String[] parts = input.trim().split("\\s+");

        // 2. Проверка количества полей
        if (parts.length != 7) {
            throw new InvalidDataCountException("Требуется 7 элементов, получено: " + parts.length);
        }

        String surname = null;
        String name = null;
        String patronymic = null;
        String birthDate = null;
        Long phoneNumber = null;
        Character gender = null;
        Integer age = null;

        List<String> textParts = new ArrayList<>();

        // 3. Распознавание типов данных (в произвольном порядке)
        for (String part : parts) {
            if (part.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
                // Это дата (dd.mm.yyyy)
                if (birthDate != null) throw new BadDataFormatException("Обнаружено более одной даты: " + part);
                birthDate = part;
            } else if (part.matches("[fm]")) {
                // Это пол (f или m)
                if (gender != null) throw new BadDataFormatException("Обнаружено более одного маркера пола: " + part);
                gender = part.charAt(0);
            } else if (part.matches("\\d+")) {
                // Это число (телефон или возраст)
                // Логика: Возраст обычно < 150, Телефон - длинное число.
                long num = Long.parseLong(part);
                if (num < 150) {
                    // Считаем это возрастом (если возраст еще не был найден)
                    // Нюанс: если телефон тоже короткий (например, "102"), этот алгоритм может ошибиться без доп. контекста.
                    // Но в рамках задачи считаем возраст маленьким числом, телефон большим.
                    if (age == null) {
                        age = (int) num;
                    } else {
                        // Если возраст уже есть, значит это странный телефон, или второй возраст (ошибка)
                        phoneNumber = num;
                    }
                } else {
                    phoneNumber = num;
                }
            } else {
                // Всё остальное считаем частями имени (ФИО)
                textParts.add(part);
            }
        }

        // --- Валидация собранных данных ---

        StringBuilder errors = new StringBuilder();

        if (textParts.size() != 3) {
            errors.append("Не удалось выделить ровно 3 части имени (ФИО). Найдено: ").append(textParts).append("\n");
        } else {
            // Предполагаем порядок: 1-Фамилия, 2-Имя, 3-Отчество
            // Так как программно отличить их невозможно без словаря
            surname = textParts.get(0);
            name = textParts.get(1);
            patronymic = textParts.get(2);
        }

        if (birthDate == null) errors.append("Не найдена дата рождения формата dd.mm.yyyy\n");
        if (gender == null) errors.append("Не найден пол (f или m)\n");
        if (phoneNumber == null) errors.append("Не найден номер телефона\n");
        if (age == null) errors.append("Не найден возраст\n");

        if (errors.length() > 0) {
            throw new BadDataFormatException("\n" + errors.toString());
        }

        return new Person(surname, name, patronymic, birthDate, phoneNumber, gender, age);
    }

    // 4, 5, 6. Метод записи в файл
    private static void writeFile(Person person) throws IOException {
        String fileName = person.surname + ".txt";

        // try-with-resources автоматически закроет файл (пункт 6)
        // параметр true в FileWriter включает режим append (дозапись) (пункт 5)
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(person.toString() + "\n");
        }
    }
}
