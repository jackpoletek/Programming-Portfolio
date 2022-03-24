public class Main {

    public static void main(String[] args) {

        int[] array = {12, 34, 45, 2, 10, -99, 0, 1000000};

        int min = MinValue.minValue(array);
        int max = MaxValue.maxValue(array);

        System.out.println("Minimum value: " + min);
        System.out.println("Maximum value: " + max);
    }
}
