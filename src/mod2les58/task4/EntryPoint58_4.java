package mod2les58.task4;

import java.util.Arrays;
import java.util.Random;
import static java.lang.Math.round;

public class EntryPoint58_4 {
    public static void main(String[] args) {
        //Напишите программу, которая создает массив из 20 целочисленных элементов,
        int[] intArray = new int[6];

        //заполняет случайным образом , выводит элементы в одну строку, разделив пробелами.
        EntryPoint58_4 ep58_4 = new EntryPoint58_4();
        ep58_4.fillArray(intArray);
        System.out.println("Создан массив : " + Arrays.toString(intArray));

        //Для сортировки массива используйте метод Arrays.sort или метод bubbleSort из третьего задания.
        int[] intArray2 = intArray.clone();
        Arrays.sort(intArray2);

        //Затем, используя метод median, получите и выведите значение вычисленной медианы.
        System.out.println("Медиана : " + ep58_4.median(intArray2));

        //После этого вновь напечатайте элементы исходного массива в одну строку, разделив пробелами,
        //чтобы убедиться, что их порядок не изменился.
        System.out.println("Повторный ввод исходного массива : " + Arrays.toString(intArray));
    }

    /*
    Реализуйте метод int median(int[] a), который возвращает целочисленное значение медианы
    массива а.
    Для отсортированного массива четной длины медиана расчитывается как среднее
    арифметическое двух центральных элементов.
    Для отсортированного массива нечетной длины медиана расчитывается как
    центральный элемент.
     */
    int median(int[] a){
        if(a.length % 2 == 0){
            // !!! возвращаем инт поэтому так, иначе как дабл/флоат возвращать та !
            return (a[(a.length / 2) - 1] + a[a.length / 2]) / 2;
        }
        else return a[a.length / 2];
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
