public class AddMultiply {

    public int addMulti(int[] arr) {

        int result;
        int multiply = 0;
        int sum = 0;
        int i = 0;

        int length = arr.length-1;

        if (arr.length == 1) {
            return arr[i];
        }

        while (i < arr.length-1) {

            if (arr.length%2 != 0) {
                sum = arr[0];
            }
            else sum = arr[0] + arr[length];

            i++;

            if (i >= length) {
                break;
            }

            multiply += arr[i] * arr[i+1];
            i++;
        }

        result = sum + multiply;
        return result;
    }
}

