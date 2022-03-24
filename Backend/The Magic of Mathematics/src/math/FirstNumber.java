package math;

import java.util.ArrayList;
import java.util.List;

public class FirstNumber implements Instructed {

    private List<Integer> firstNumber = new ArrayList<>();

    public List<Integer> getFirstNumber() {
        return firstNumber;
    }

    public void instructions() throws InterruptedException {

        for (int i = 0; i < instructions.length; i++) {
            System.out.printf("%s\n", instructions[i]);
            Thread.sleep(4000);
        }
    }

    public List<Integer> generateNumber() {

        int randomNumber = (int) (Math.random()*899) + 100;

        firstNumber.add(randomNumber);
        return firstNumber;
    }

    @Override
    public String toString() {

        return "This is the first number: " + getFirstNumber();
    }
}
