package mod2les58.task6;

public class EntryPoint58_6 {
    public static void main(String[] args) {

        //- создает объект DynamicArray
        DynamicArray array = new DynamicArray(0);

        //- получает через аргументы командной строки целочисленные значения,
        //- добавляет в него переданные элементы
        for(int i = 0; i < args.length; i++){
            array.add(Integer.parseInt(args[i]));
        }

        //- печатает полученный объект
        System.out.printf("Object 1 : %s%c", array, '\n');

        //- создает второй объект DynamicArray
        //- копирует все значения из первого во второй
        DynamicArray vector = new DynamicArray(array.get(0, array.getLength() - 1));

        //- удаляет один элемент второго объекта
        vector.delete(4);

        //- печатает элементы первого объекта
        System.out.printf("Object 1 : %s%c", array, '\n');
        //- печатает элементы второго объекта
        System.out.printf("Object 2 : %s%c", vector, '\n');
    }
}
