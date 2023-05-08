package mod6les4.task3;

import java.util.Arrays;

public class LowNumbersDeleteQueue implements iQueue {
    private int[] intArray;

    public LowNumbersDeleteQueue(int... inputArray) {
        intArray = inputArray;
    }

    @Override
    public String toString() {
        String outStr = "оставшиеся элементы: ";
        if (intArray.length > 0)
            for (int i = 0; i < intArray.length; i++)
                outStr = outStr.concat(intArray[i] + " ");
        else
            outStr = "элементы отсутствуют";
        return outStr;
    }

    @Override
    public void add(int value){
        int[] tempArray = new int[intArray.length + 1];

        for (int i = 0; i < intArray.length; i++) {
            tempArray[i] = intArray[i];
        }

        tempArray[tempArray.length - 1] = value;
        intArray = tempArray.clone();
    }

    @Override
    public int remove(){
        int[] tempArray = new int[intArray.length - 1];
        int newArrayPos = 0;
        int minValuePos = findPositionOfMinValue();

        for (int i = 0; i < intArray.length; i++) {
            if(i == minValuePos)
                continue;
            tempArray[newArrayPos] = intArray[i];
            newArrayPos++;
        }
        int res = intArray[minValuePos];
        intArray = tempArray.clone();

        return res;
    }

    private int findPositionOfMinValue(){
        int res = 0;
        for (int i = 1; i < intArray.length; i++) {
            if(intArray[res] > intArray[i]){
                res = i;
            }
        }
        return res;
    }

    @Override
    public boolean isEmpty(){
        if(intArray.length == 0)
            return true;
        else
            return false;
    }

    public String anotherToString(){
        String outStr = "";
        for (int i = 0; i < intArray.length; i++)
            outStr = outStr.concat(intArray[i] + " ");
        return outStr;
    }

    public void sort(Swap method){
        for (int j = 0; j < intArray.length - 1; j++) {
            for (int i = 0; i < intArray.length - 1; i++){
                if(method.needToSwap(intArray[i], intArray[i + 1])){
                    int temp = intArray[i];
                    intArray[i] = intArray[i + 1];
                    intArray[i + 1] = temp;
                }
            }
        }
    }
}
