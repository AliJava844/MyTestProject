package homeworks.homework13;

import homeworks.homework13.utils.InputUtils;

public class App {
    public static void main(String[] args) {
        // ТЕСТ Integer
        System.out.println("=== validateCount ===");
        System.out.println(InputUtils.validateCount("123"));     // 123
        System.out.println(InputUtils.validateCount("12a"));     // ошибка

        // ТЕСТ Double
        System.out.println("=== validateNumber ===");
        System.out.println(InputUtils.validateNumber("12.5"));   // 12.5
        System.out.println(InputUtils.validateNumber("12,5"));   // ошибка
    }
}
