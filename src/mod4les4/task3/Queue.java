package mod4les4.task3;

import java.util.Arrays;

public class Queue implements iQueue {
    private int[] intArray;

    Queue(int... inputArray) {
        intArray = inputArray.clone();
    }

    @Override
    public int remove() {
        int[] tempArray = new int[intArray.length - 1];
        int res = intArray[0];

        for (int i = 1; i < intArray.length; i++) {
            tempArray[i - 1] = intArray[i];
        }
        intArray = tempArray.clone();

        return res;
    }

    @Override
    public void add(int value) {
        int[] tempArray = new int[intArray.length + 1];

        for (int i = 0; i < intArray.length; i++) {
            tempArray[i] = intArray[i];
        }

        tempArray[tempArray.length - 1] = value;
        intArray = tempArray.clone();
    }

    @Override
    public boolean isEmpty() {
        if (intArray.length == 0)
            return true;
        else
            return false;
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
}
