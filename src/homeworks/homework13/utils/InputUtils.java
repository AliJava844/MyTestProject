package homeworks.homework13.utils;

public class InputUtils {
    // 2. parseCount — парсинг Integer
    public static int parseCount(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Невалидное значение");
        }
    }

    // 3. validateCount — возвращает число или ошибку
    public static Object validateCount(String value) {
        try {
            return parseCount(value);
        } catch (IllegalArgumentException e) {
            return e;
        }
    }

    // 4. parseNumber — парсинг Double
    public static double parseNumber(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Невалидное значение");
        }
    }

    // 5. validateNumber — возвращает число или ошибку
    public static Object validateNumber(String value) {
        try {
            return parseNumber(value);
        } catch (IllegalArgumentException e) {
            return e;
        }
    }

}
