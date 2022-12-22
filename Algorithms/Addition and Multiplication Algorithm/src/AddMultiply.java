public class AddMultiply {

    public int addMulti(int[] arr) {

        int result;
        int multiply = 0;
        int sum = 0;
        int i = 0;

        int length = arr.length;
		int first = arr[0];
        int last = arr[length-1];

        if (length == 1) {
            return arr[i];
        }

        while (i < length-1) {

            // Odd number of array elements
        	// Add only the first element
            if (length%2 != 0) {
                sum = first;
            }
            
            // Even number of array elements
            else sum = first + last;
            i++;

            if (i >= length-1) {
                break;
            }

            multiply += arr[i] * arr[i+1];
            i++;
        }

        result = sum + multiply;
        return result;
    }
}

