package homeworks.homework12.task2;

public class User {
    private String login;
    private String password;

    // Конструктор
    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    // Геттеры
    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    /**
     * Статический метод проверки.
     */
    public static boolean validate(String login, String password, String confirmPassword) {
        try {
            // Проверка логина
            if (!login.matches("[A-Za-z0-9_]+") || login.length() >= 20) {
                throw new WrongLoginException("Invalid login format");
            }

            // Проверка пароля
            if (!password.matches("[A-Za-z0-9_]+") || password.length() >= 20) {
                throw new WrongPasswordException("Invalid password format");
            }

            // Проверка подтверждения
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Password mismatch");
            }

            return true; // если все проверки прошли

        } catch (WrongLoginException | WrongPasswordException ex) {
            System.out.println("Ошибка: " + ex.getMessage());
            return false;
        }
    }
}
