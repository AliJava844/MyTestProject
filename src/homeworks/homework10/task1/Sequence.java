package homeworks.homework10.task1;

import java.util.Arrays;

public class Sequence {

    public static int[] filter(int[] array, ByCondition condition) {
        int[] result = new int[]{};
        int counter = 0;
        for (int number : array) {
            if (condition.isOk(number)) {
                result = Arrays.copyOf(result, result.length + 1);
                result[counter] = number;
                counter++;
            }
        }
        return result;
    }
}
