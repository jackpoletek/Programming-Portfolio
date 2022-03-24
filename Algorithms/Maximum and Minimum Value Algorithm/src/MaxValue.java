public class MaxValue {

    public static int maxValue(int[] input) {

        // min value
        int max = Integer.MIN_VALUE;

        // TERNARY OPERATOR
        for (int value : input) {
            max = value > max ? value : max;
        }
        return max;
    }
}
