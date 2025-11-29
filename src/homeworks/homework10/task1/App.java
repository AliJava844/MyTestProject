package homeworks.homework10.task1;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int[] array = {10, 11, 12, 3, 5, 4, 23, 24, 34, 46};

        ByCondition byCondition = number -> number % 2 == 0;

        int[] result = Sequence.filter(array, byCondition);

        System.out.println(Arrays.toString(result));

        ByCondition byCondition1 = number -> {
            int sum = 0, x = number;

            if (x < 10)
                return false;


            while (x != 0) {
                sum += x % 10;
                x /= 10;
            }
            return sum % 2 == 0;
        };

        int[] sumElemEven = Sequence.filter(array, byCondition1);

        System.out.println(Arrays.toString(sumElemEven));
    }
}
