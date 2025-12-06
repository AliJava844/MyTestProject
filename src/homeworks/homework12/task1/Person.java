package homeworks.homework12.task1;

public class Person {
    String surname;
    String name;
    String patronymic;
    String birthDate;
    long phoneNumber;
    char gender;
    int age;

    public Person(String surname, String name, String patronymic, String birthDate, long phoneNumber, char gender, int age) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        // Формат вывода: <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
        // Добавил возраст в конец, так как он был в требованиях на вход, но в формате файла его явно не указали,
        // но логично сохранить все распарсенные данные.
        return String.format("<%s><%s><%s><%s> <%d><%c><%d>",
                surname, name, patronymic, birthDate, phoneNumber, gender, age);
    }
}
