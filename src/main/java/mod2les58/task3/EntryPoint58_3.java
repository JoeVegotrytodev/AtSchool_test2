package mod2les58.task3;

import java.util.Random;

public class EntryPoint58_3 {

    public static void main(String[] args) {
        int[] intArray = new int[20];

        /*
        Используя метод fillArray из первого задания и метод bubbleSort, напишите программу,
        которая создает массив из 20 целочисленных элементов, выводит элементы в одну строку,
        разделив пробелами. Затем, используя метод bubbleSort, сортирует созданный массив
        и выводит элементы отсортированного массива в одну строку, разделив пробелами.
         */
        EntryPoint58_3 ep58_3 = new EntryPoint58_3();
        ep58_3.fillArray(intArray);
        ep58_3.printArray(intArray);
        ep58_3.bubbleSort(intArray);
        System.out.println('\n');
        ep58_3.printArray(intArray);
    }

    /*
    Реализуйте метод void bubbleSort(int[] a),
    который сортирует целочисленные элементы в массиве a по возрастанию
    (первый элемент - минимальный) согласно алгоритму пузырьковой сортировки.
    en.wikipedia.org/wiki/Bubble_sort
     */
    void bubbleSort(int[] a) {
        for(int j = 1; j < a.length - 1; j++){
            for(int i = 0; i < a.length -j; i++){
                if(a[i] > a[i + 1]){
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        }
    }

    void printArray(int[] a){
        for(int i : a){
            System.out.print(i + " ");
        }
    }

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
