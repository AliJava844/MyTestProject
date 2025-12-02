package homeworks.homework09;

import homeworks.homework09.car.Car;
import homeworks.homework09.car.PerformanceCar;
import homeworks.homework09.car.ShowCar;
import homeworks.homework09.race.CircuitRace;
import homeworks.homework09.race.Race;
import homeworks.homework09.race.TimeLimitRace;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        TimeLimitRace timeLimitRace = new TimeLimitRace();
        CircuitRace circuitRace = new CircuitRace();

        // создание файла для чтения
        try {
            File myFile = new File("input1.txt");
            if (myFile.createNewFile()) {
                System.out.println("Файл создан");
            } else {
                System.out.println("Файл уже существует");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла");
            e.printStackTrace();
        }

        // запись в файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("input1.txt"))) {
            writer.write("CAR BMW 320i 170 2012 8 100 80");
            writer.newLine();
            writer.write("PERFORMANCE Audi RS3 2020 400 6 80 90 Turbo,Sport");
            writer.newLine();
            writer.write("SHOW Porsche GTTurbo3S 2021 600 4 70 95 5");
            writer.newLine();
            writer.write("RACE 1000 Highway 50000");
            writer.newLine();
            writer.write("TIME 1500 City 80000 120");
            writer.newLine();
            writer.write("CIRCUIT 500 Track 100000 5");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл");
            e.printStackTrace();
        }

        // чтение из файла
        List<Car> carList = new ArrayList<>();
        List<Race> raceList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("input1.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] p = line.split(" ");

                switch (p[0]) {

                    case "CAR":
                        carList.add(new Car(p[1], p[2],
                                Integer.parseInt(p[3]),
                                Integer.parseInt(p[4]),
                                Integer.parseInt(p[5]),
                                Integer.parseInt(p[6]),
                                Integer.parseInt(p[7])
                        ));
                        break;

                    case "PERFORMANCE":
                        carList.add(new PerformanceCar(p[1], p[2],
                                Integer.parseInt(p[3]),
                                Integer.parseInt(p[4]),
                                Integer.parseInt(p[5]),
                                Integer.parseInt(p[6]),
                                Integer.parseInt(p[7]),
                                p[8].split(",")
                        ));
                        break;

                    case "SHOW":
                        carList.add(new ShowCar(p[1], p[2],
                                Integer.parseInt(p[3]),
                                Integer.parseInt(p[4]),
                                Integer.parseInt(p[5]),
                                Integer.parseInt(p[6]),
                                Integer.parseInt(p[7]),
                                Integer.parseInt(p[7])
                        ));
                        break;

                    case "RACE":
                        raceList.add(new Race(Integer.parseInt(p[1]),
                                p[2], Integer.parseInt(p[3]), carList));
                        break;

                    case "TIME":
                        raceList.add(new TimeLimitRace(Integer.parseInt(p[1]),
                                p[2], Integer.parseInt(p[3]), carList, Integer.parseInt(p[4])));
                        break;

                    case "CIRCUIT":
                        raceList.add(new CircuitRace(Integer.parseInt(p[1]),
                                p[2], Integer.parseInt(p[3]), carList, Integer.parseInt(p[4])));
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла");
            e.printStackTrace();
        }

        Garage garage = new Garage(carList);
        garage.modifiedCar(2);

        // создание файла для записи
        try {
            File myFile = new File("output1.txt");
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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output1.txt"))) {
            for (Car car : carList) {
                writer.write(car.toString());
                writer.newLine();
            }

            for (Race race: raceList) {
                writer.write(race.toString());
                writer.newLine();
            }

            writer.newLine();

            writer.write(raceList.get(0).casualRace(carList.get(0)));
            writer.newLine();
            writer.write(timeLimitRace.timeLimitRace(carList.get(1)));
            writer.newLine();
            writer.write(circuitRace.circuitRace(carList.get(2)));
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл");
            e.printStackTrace();
        }
    }
}
