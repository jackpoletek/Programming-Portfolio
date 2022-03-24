package NumbersModel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NumbersModel {

    // MODEL holds data and performs calculations, calls methods, provides access to data

    private List<Integer> userArray = new ArrayList<>();
    private int[] array;
    private int number;
    private LinkedList<Integer> linkedList = new LinkedList<>();
    private List<Integer> compArray = new ArrayList<>();
    private int[] firstCompArr;
    private int[] secondCompArr;
    private int compNum1;
    private int compNum2;

    public List<Integer> getUserArray() {
        return userArray;
    }

    public int[] getArray() {
        return array;
    }

    public int getNumber() {
        return number;
    }

    public LinkedList<Integer> getLinkedList() {
        return linkedList;
    }

    public List<Integer> getCompArray() {
        return compArray;
    }

    public int[] getFirstCompArr() {
        return firstCompArr;
    }

    public int[] getSecondCompArr() {
        return secondCompArr;
    }

    public int getCompNum1() {
        return compNum1;
    }

    public int getCompNum2() {
        return compNum2;
    }

    // GET 2 INTS and STORE THEM IN List<Integer> userArray
    public void getUserInput(int firstUserNum, int secondUserNum) {

        userArray.add(firstUserNum);
        userArray.add(secondUserNum);
    }
    // CONVERT List<Integer> userArray to ARRAY -> int[] array
    public void listToIntArr() {

        array = new int[userArray.size()];

        for (int i = 0; i < userArray.size(); i++) {
            array[i] = userArray.get(i);
        }
    }
    // CONVERT ARRAY int[] array TO a SINGLE INTEGER
    public void intArrayToInt() {

        StringBuilder builder = new StringBuilder();
        for (int arr : array) {
            builder.append(arr);
        }
        number = Integer.parseInt(builder.toString());
    }
    // SPLIT INTEGER and ADD IT TO LINKED LIST -> LinkedList<Integer> split as a series of digits
    public void splitInt() {

        while (number > 0) {
            linkedList.push(number % 10);
            number = number / 10;
        }
    }
    // FOR EACH ELEMENT OF LinkedList<Integer> split: 9-element and ADD IT TO List<Integer> compArray
    public void generateCompNums() {

        int limit = 9;

        for (int s : linkedList) {
            compArray.add(limit - s);
        }
    }
    // DIVIDE COMPUTER LIST compArray INTO 2 SUBLISTS AND STORE THEM IN 2 INT ARRAYS
    public void compArrToIntArray() {

        List<Integer> head = compArray.subList(0, 3);
        List<Integer> tails = compArray.subList(3, 6);
        firstCompArr = new int[head.size()];
        secondCompArr = new int[tails.size()];

        for (int i = 0; i < head.size(); i++) {
            firstCompArr[i] = head.get(i);
        }
        for (int i = 0; i < tails.size(); i++) {
            secondCompArr[i] = tails.get(i);
        }
    }
    // CONVERT int[] firstCompArr and int[] secondCompArr into respective integers
    public int intArrToCompNum(int first, int second) {

        for (int i = 0; i < firstCompArr.length; i++) {
            compNum1 = 10 * compNum1 + firstCompArr[i];
        }
        for (int i = 0; i < secondCompArr.length; i++) {
            compNum2 = 10 * compNum2 + secondCompArr[i];
        }
        return compNum2;
    }
}
