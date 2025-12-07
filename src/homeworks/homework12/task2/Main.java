package homeworks.homework12.task2;

public class Main {
    public static void main(String[] args) {
        boolean valid = User.validate("Admin_1", "pass_333", "pass_333");

        System.out.println("Valid: " + valid);
    }
}
