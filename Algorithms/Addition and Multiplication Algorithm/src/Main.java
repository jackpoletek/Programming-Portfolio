public class Main {

    public static void main (String[] args) {

        AddMultiply addMultiply = new AddMultiply();
        int[] array1 = {3, 5, 10, 7, 9, 3};
        int[] array2 = {2, 9, 13, 3, 5, 4, 5};
        int arr1 = addMultiply.addMulti(array1);
        int arr2 = addMultiply.addMulti(array2);
        System.out.println("Array 1: " + arr1);
        System.out.println("Array 2: " + arr2);
    }
}
