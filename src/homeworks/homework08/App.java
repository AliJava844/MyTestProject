package homeworks.homework08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        List<Product> bag = new ArrayList<>();
        List<Person> persons = new ArrayList<>();
        List<String> purchases = new ArrayList<>();

        // создание файла для записи
        try {
            File myFile = new File("input.txt");
            if (myFile.createNewFile()) {
                System.out.println("Файл создан");
            } else {
                System.out.println("Файл уже существует");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла");
            e.printStackTrace();
        }

        // запись в файл input
        try (FileWriter writer = new FileWriter("input.txt");) {
            writer.write("Павел Андреевич = 10000; Анна Петровна = 2000; Борис = 10\n");
            writer.write("Хлеб = 40; Молоко = 60; Торт = 1000; Кофе растворимый = 879; Масло = 150\n");
            writer.write("""
                    Павел Андреевич-Хлеб
                    Павел Андреевич-Масло
                    Анна Петровна-Кофе растворимый
                    Анна Петровна-Молоко
                    Анна Петровна-Молоко
                    Анна Петровна-Молоко
                    Анна Петровна-Торт
                    Борис-Торт
                    Павел Андреевич-Торт
                    END
                    """);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл");
            e.printStackTrace();
        }

        // чтение из файла
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("input.txt"))) {
            String line;

            // код добавления покупателей
            line = reader.readLine();
            String[] personStringArray = line.split(";");

            for (int i = 0; i < personStringArray.length; i++) {
                persons.add(new Person(personStringArray[i], bag));
                }

            // код добавления продуктов
            line = reader.readLine();
            String[] productStringArray = line.split(";");

            for (int i = 0; i < productStringArray.length; i++) {
                products.add(new Product(productStringArray[i]));
            }
            // чтение покупок
            while ((line = reader.readLine()) != null) {
                if (line.equalsIgnoreCase("END"))
                    break;
                purchases.add(line.trim());
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла");
            e.printStackTrace();
        }

        try {
            File myFile = new File("output.txt");
            if (myFile.createNewFile()) {
                System.out.println("Файл создан");
            } else {
                System.out.println("Файл уже существует");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла");
            e.printStackTrace();
        }

        // запись в файл output
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {

            // ложим продукты в сумку
            for(String purchase: purchases) {
                String[] parts = purchase.split("-");

                String personName = parts[0].trim();
                String productName = parts[1].trim();

                for (int i = 0; i < persons.size(); i++) {
                    if (persons.get(i).getName().equals(personName)) {
                        for (int j = 0; j < products.size(); j++) {
                            if (products.get(j).getNameProduct().equals(productName)) {
                                writer.write(persons.get(i).addProduct(products.get(j)));
                                writer.newLine();
                            }
                        }
                    }
                }
            }
            // итог покупок
            for (int i = 0; i < persons.size(); i++) {
                writer.write(String.valueOf(persons.get(i)));
                for (int j = 0; j < persons.get(i).getBag().size(); j++) {
                    writer.write(String.valueOf(persons.get(i).getBag().get(j)));
                    // Добавляем разделитель  запятую, кроме последнего элемента
                    if (j < persons.get(i).getBag().size() - 1) {
                        writer.write(", ");
                    }
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл");
            e.printStackTrace();
        }
    }
}
