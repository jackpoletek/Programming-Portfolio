public class MinValue {

    public static int minValue(int[] input) {

        // max value
        int min = Integer.MAX_VALUE;

        // TERNARY OPERATOR
        for (int value : input) {
            min = value < min ? value : min;
        }
        return min;
    }
}
