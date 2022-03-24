package math;

import java.util.ArrayList;
import java.util.List;

public class Numbers extends AbstractNumbers implements Instructed {

    @Override
    public List<Integer> addListElements(List<Integer> list1, List<Integer> list2, List<Integer> list3) {

        // Double braces initialization
        // The outer braces - anonymous inner class
        // The inner braces - instantiation initializers
        List<Integer> newList = new ArrayList<>()
        {{
            for (int i = 0; i < list1.size(); i++) {

                add(list1.get(i));
                add(list2.get(i));

                if (list3.size() > i) {
                    add(list3.get(i));
                }
            }
        }};
        return newList;
    }

    @Override
    public int sumOfNumbers(List<Integer> numbers) throws InterruptedException {
        int sum = 0;

        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }

        for (int i = 0; i < result.length; i++) {
            System.out.printf("%s\n", result[i]);
            Thread.sleep(5000);
        }
        return sum;
    }
}
