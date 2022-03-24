package math;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumbers extends Logic {

    private List<Integer> compNumbers = new ArrayList<>();
    Logic l = new Logic();

    public List<Integer> getCompNumbers() {
        return compNumbers;
    }

    @Override
    public List<Integer> addCompNumbers(UserNumbers n) {

        int[] compNums = l.strToIntArr(n);

        for (int i = 0; i < compNums.length; i++) {
            compNumbers.add(compNums[i]);
        }
        return compNumbers;
    }

    @Override
    public String toString() {

        return "These are my two extra numbers: " + getCompNumbers();
    }
}
