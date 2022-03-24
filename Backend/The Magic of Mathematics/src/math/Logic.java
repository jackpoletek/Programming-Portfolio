package math;

import java.util.ArrayList;
import java.util.List;

public class Logic implements Limited {

    private List<Integer> numbers = new ArrayList<>();

    public Logic() {
    }

    public String[] listToStringArr(UserNumbers n) {

        String[] strArray = new String[n.getUserNumbers().size()];

        for (int i = 0; i < strArray.length; i++) {
            strArray[i] = String.valueOf(n.getUserNumbers().get(i));
        }
        return strArray;
    }

    public String stringArrToStr(UserNumbers n) {

        String[] num = listToStringArr(n);
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < num.length; i++) {
            sb.append(num[i]);
        }
        String digit = sb.toString();
        return digit;
    }

    public String[] splitString(UserNumbers n) {

        String splitNumber = stringArrToStr(n);
        String[] splitArr = splitNumber.split("");

        return splitArr;
    }

    @Override
    public List<Integer> generateDigits(UserNumbers n) {

        String[] no = splitString(n);
        List<Integer> compNums = new ArrayList<>();
        int compNum = 0;

        for (int i = 0; i < no.length; i++) {
            compNum = upperLimit - Integer.parseInt(no[i]);
            compNums.add(compNum);
        }
        return compNums;
    }

    public String listToStr(UserNumbers n) {

        List<Integer> compNum = generateDigits(n);
        String[] num = new String[compNum.size()];

        for (int i = 0; i < compNum.size(); i++) {
            num[i] = String.valueOf(compNum.get(i));
        }

        String number = String.join("", num);
        return number;
    }

    public int[] strToIntArr(UserNumbers n) {

        String num = listToStr(n);

        String num1 = null;
        String num2 = null;

        for (int i = 0; i < num.length(); i++) {
            num1 = num.substring(0, 3);
            num2 = num.substring(3, 6);
        }

        int number1 = Integer.parseInt(num1);
        int number2 = Integer.parseInt(num2);

        int numbers [] = {number1, number2};

        return numbers;
    }

    public List<Integer> addCompNumbers(UserNumbers n) {
        return numbers;
    }
}
