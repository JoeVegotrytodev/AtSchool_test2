package mod2les58.task1;

import java.util.Random;

public class EntryPoint58_1 {
    public static void main(String[] args) {
        /*
        Напишите программу, которая создает массив из 20 целочисленных
        элементов, заполняет его случайными значениями, используя метод
         fillArray,и печатает его элементы в одну строку, разделив пробелами.
         */
        int[] intArray = new int[20];

        EntryPoint58_1 ep = new EntryPoint58_1();
        ep.fillArray(intArray);

        for(int i : intArray)
            System.out.print(i + " ");

    }
    /*
    Реализуйте метод void fillArray(int[] a),
    который устанавливает элементам целочисленного массива а
    случайные целые числа -9 до 9.
     */
    void fillArray(int[] a){
        int maxValue = 9;
        int minValue = -9;
        int range = maxValue - minValue + 1;

        Random random = new Random();

        for(int i = 0; i < a.length; i++){
            a[i] = random.nextInt(range) + minValue;
        }
    }
}
