package math;

import java.util.List;

public class App {

    public static void main (String[] args) throws InterruptedException {

        FirstNumber firstNumber = new FirstNumber();
        firstNumber.instructions();
        firstNumber.generateNumber();
        System.out.println(firstNumber);

        UserNumbers userNumbers = new UserNumbers();
        userNumbers.run();
        userNumbers.close();
        System.out.println(userNumbers);

        ComputerNumbers computerNumbers = new ComputerNumbers();
        computerNumbers.addCompNumbers(userNumbers);
        System.out.println(computerNumbers);

        Numbers numbers = new Numbers();
        List<Integer> uberList = numbers.addListElements(userNumbers.getUserNumbers(), computerNumbers.getCompNumbers(), firstNumber.getFirstNumber());
        int sum = numbers.sumOfNumbers(uberList);
        System.out.println(sum);

    }
}
