package mod2les58.task5;

import java.util.Arrays;
import java.util.Random;

public class EntryPoint58_5 {
    public static final int MAX_LINES = 5;
    public static final int MAX_COL = 7;

    public static void main(String[] args) {
        /*
    Напишите программу, которая создает зубчатый массив целочисленных
    элементов, сгенеренных случайным образов в диапазоне -9 до 9.
    Массив должен содержать не более 5 строк и каждая строка иметь
    не более 7 столбцов.
    Выведите массив на экран в порядке убывания сумм элементов строк.
     */
        int[][] intArray = new int[MAX_LINES][];
        intArray[0] = new int[MAX_COL];
        intArray[1] = new int[3];
        intArray[2] = new int[5];
        intArray[3] = new int[1];
        intArray[4] = new int[2];

        //значения для генерации чисел
        int maxValue = 9;
        int minValue = -9;
        int range = maxValue - minValue + 1;
        Random random = new Random();

        //генерация значений массива
        for(int i = 0; i < MAX_LINES; i++){
            for(int j = 0; j < intArray[i].length; j++){
                intArray[i][j] = random.nextInt(range) - minValue;
            }
        }

        //для ранения сумм массивов
        int[] sums = new int[MAX_LINES];

        //подсчет сумм массивов
        for(int i = 0; i < MAX_LINES; i++){
            int sum = 0;
            for(int j = 0; j < intArray[i].length; j++){
                sum += intArray[i][j];
            }
            sums[i] = sum;
        }

        //сортировка - делаю до 3его задания урока 58, там вроде алгоритм сортировки был
        for(int i = 0; i < sums.length; i++){
            for(int j = i; j < sums.length; j++) {
                //если в другом массиве сумма больше
                if (sums[i] < sums[j]) {
                    //то меняем значения
                    int[] temp = intArray[i].clone();
                    intArray[i] = intArray[j].clone();
                    intArray[j] = temp.clone();
                }
            }
        }

        System.out.println(Arrays.deepToString(intArray));
    }
}
