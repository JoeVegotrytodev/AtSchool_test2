package mod2les58.task6;

import java.util.Arrays;

/*
Напишите класс DynamicArray - класс, реализующий массив целых чисел
с изменяемым размером. Для хранения значений используется внутренний приватный
обычный массив.
 */
public class DynamicArray {
    //Для хранения значений используется внутренний приватный обычный массив.
    private int[] intArray;
    //для добавления/удаления элементов
    private int putLoc, getLoc;

    //- конструктор с целочисленным параметром
    // - начальным размером массива
    //создает внутренний массив указанного размера
    DynamicArray(int size) {
        intArray = new int[size];
        //индексы ставлю в ноль, как правило массив создается пустой
        putLoc = getLoc = 0;
    }

    //конструктор с параметром-массивом
    //создает внутреннюю копию переданного массива
    DynamicArray(int[] array) {
        intArray = new int[array.length];
        intArray = array.clone();
        putLoc = getLoc = array.length - 1;
    }

    //печатает все элементы массива в строку через пробел
    @Override
    public String toString() {
        String str = "";
        for(int i : intArray){
            str += i;
            str += ' ';
        }
        return str += '\n';
    }

    //добавить один элемент в конец внутреннего массива
    void add(int x) {
        //увеличиваем размер массива на 1
        int[] intArray2 = new int[intArray.length + 1];

        //копируем старые элементы
        for (int i = 0; i < intArray.length; i++) {
            intArray2[i] = intArray[i];
        }
        putLoc = getLoc = intArray.length;
        //добавляем новый эл-т
        intArray2[putLoc] = x;
        //обновляем индексы
        getLoc = putLoc++;
        //заменяем массив
        intArray = intArray2.clone();
    }

    //добавить элементы из переданного массива в конец внутреннего
    void add(int[] x){
        //увеличиваем размер
        int[] tempArray = new int[intArray.length + x.length];
        //копируем старые эл-ты
        for (int i = 0; i < intArray.length; i++) {
            tempArray[i] = intArray[i];
        }
        putLoc = intArray.length;
        //доабвляем новые эл-ты
        for(int j = 0; j < x.length; j++){
            tempArray[putLoc] = x[j];
            putLoc++;
        }
        getLoc = tempArray.length - 1;
        //заменяем массив
        intArray = tempArray.clone();
    }

    //получить один элемент массива с позиции n
    int getAt(int n){
        if(n <= getLoc) return intArray[n];
        else throw new ArrayIndexOutOfBoundsException();
    }

    //получить массив элементов с начиная с позиции from до to
    int[] get(int from, int to){
        //массив для хранения рез-та
        int[] result = new int[to - from + 1];
        int index = from;

        //отбор элементов по индексам
        if(from >= 0 & to <= getLoc){
            for(int i = 0; i < result.length; i++){
                result[i] = intArray[index++];
            }
        }
        else throw new ArrayIndexOutOfBoundsException();

        return result;
    }

    //удалить элемент из массива на позиции n
    void delete(int n){
        if(n < 0 | n >= intArray.length)
            throw new ArrayIndexOutOfBoundsException();

        //создаем меньший массив и запоминаем туда значения
        int[] tempArray = new int[intArray.length - 1];

        for(int i = 0, currentLoc = 0; i < intArray.length; i++){
            //пропускаем итерацию, когда встречаем удаляемый символ
            if(i == n) continue;
            tempArray[currentLoc] = intArray[i];
            currentLoc++;
        }
        intArray = tempArray.clone();
    }

    //удалить все элементы - это задание я понял,
    // как заменить все эл-ты нулями
    void deleteAll(){
        Arrays.fill(intArray, 0);
    }

    //создла метод для следующей задачи :
    //- копирует все значения из первого во второй
    public int getLength() {
        return intArray.length;
    }
}
