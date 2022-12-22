
public class Main {

    public static void main(String[] args) {

        int[] array = {12, 8, 0, 100, 10};
        System.out.println(insertionSort(array));
        int[] arrSorted = selectSort(array);

        for (int arr: arrSorted) {
            System.out.println(arr);
        }

    }

    public static int[] selectSort(int[] arr) {

        int i, j;

        for (i = 0; i < arr.length-1; i++) {

            int lowestIndex = i;
            // String bookYouWant = i

            for (j = i+1; j < arr.length; j++) {

                if (arr[j] < arr[lowestIndex])
                lowestIndex = j;
                // if arr[j] == arr[bookYouWant]
                // bookYouWant = j;
            }

            int biggest = arr[lowestIndex];
            arr[lowestIndex] = arr[i];
            arr[i] = biggest;
            // String result = arr[bookYouWant], arr[bookYouWant] = arr[i], arr[i] = result
        }
        return arr;
    }
    public static int insertionSort(int[] arr) {

        int value = 0;

        for (int i = 1; i < arr.length; i++) {
            int j;
            int temp = arr[i];

            for (j = i-1; j >= 0; j--) {
                if (arr[j] <= temp) break;
                arr[j+1] = arr[j];
            }
            arr[j+1] = temp;
            value = arr[j+1];
        }
        return value;
    }
}
