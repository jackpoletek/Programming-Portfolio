package math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserNumbers {

    private List<Integer> userNumbers = new ArrayList<>();
    private int[] value = null;

    private Scanner in = new Scanner(System.in);

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }

    public void run() {
        getUserInput();
        addUserNumbers();
    }

    @Override
    public String toString() {

        String numbers = null;
        for (int i = 0; i < userNumbers.size(); i ++) {
            numbers = String.valueOf(userNumbers.get(i));
        }
        return "These are the numbers you've entered: " + getUserNumbers();
    }

    public int[] getUserInput() {
        int i = 0;
        int numArrayLength = 2;

        String[] numArray = new String[numArrayLength];
        value = new int[numArray.length];
        int num = 0;

        System.out.println("Now you need to enter 2 numbers. They must be between 100 and 899:");

        do {
            try {
                numArray[i] = in.nextLine();
                num = Integer.parseInt(numArray[i]);

                if (num > 899 || num < 100) {
                    System.out.println("The number must be between 899 and 100.");
                    System.out.println("Try again.");
                    continue;
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
                continue;
            }
            value[i] = num;

            i++;

        } while (i < numArray.length);

        return value;
    }

    public List<Integer> addUserNumbers() {

        for (int i = 0; i < value.length; i++) {
            userNumbers.add(value[i]);
        }
        return userNumbers;
    }

    public void close() {
        in.close();
    }
}
