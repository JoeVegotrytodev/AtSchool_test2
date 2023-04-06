package mod2les75.task1;

import java.util.Arrays;

//Напишите программу, которая через аргументы командной строки
//получает "слова" (каждый аргумент - отдельное слово)
public class EntryPoint75_1 {
    public static void main(String[] args) {
//        Если в программу не переданы аргументы, то она завершается.
//        2)
//        Ввод:
//        Вывод:
        if (args.length == 0) {
            System.out.println("Original string : ");
            System.out.println("String after deleting matches : ");
            return;
        }

//      печатает полученную последовательность слов,
        System.out.println("Original string : ");
        printStrings(args);
        System.out.println("\n\nString after deleting matches : ");

        //массив хранения неповторяющихся эл-ов
        String[] uniqueStr = new String[args.length];

        //сохраняю 0 элемент в массив уникальных элементов, потому что он уникален и
        // чтобы потом его использовать в сравнении,
        //если не укажу, то массив будет хранить null эелмент и при сравнении будет ошибка NPE
        uniqueStr[0] = args[0];

        //отбираем лишь уникальные элементы
        uniqueElementsFilter(args, uniqueStr);
    }

    /**
     * Выводит переданный массив
     *
     * @param stringToPrint массив который нужно вывести в консоль
     */
    public static void printStrings(String[] stringToPrint) {
        for (String str : stringToPrint) {
            if (str != null) {
                System.out.print(str + " ");
            }
        }
    }

    /**
     * Отбирает уникальные методы
     *
     * @param stringArray   массив строк в котором ищем дубли
     * @param uniqueStrings массив уникальных строк
     */
    private static void uniqueElementsFilter(String[] stringArray, String[] uniqueStrings) {
        //проходим по элеметам исходой строки
        for (int i = 1, index = 1; i < stringArray.length; i++) {
            //флаг является ли элемент уникальным
            boolean isUnique = true;
            for (int j = 0; j < uniqueStrings.length; j++) {
                //если строки равны
                if (stringArray[i].equals(uniqueStrings[j])) {
                    //то считаем строку не уникальной
                    isUnique = false;
                    //раз строка уже совпала с другой, то смысла далее по циклу ее нет
                    break;
                }
            }
            //если же строка уникальна - сохраняем в массив уникальных элементов
            if (isUnique) {
                uniqueStrings[index] = stringArray[i];
                index++;
            }
        }
        //выводим только уникальные слова из переданной последовательности.
        printStrings(uniqueStrings);
    }
}
