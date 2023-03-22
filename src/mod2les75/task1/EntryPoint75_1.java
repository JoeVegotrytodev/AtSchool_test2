package mod2les75.task1;

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


//        печатает полученную последовательность слов,
        System.out.println("Original string : ");
        for (String str : args)
            System.out.print(str + ' ');


        System.out.println("\n\nString after deleting matches : ");
        //массив хранения неповторяющихся эл-ов
        String[] uniqueStr = new String[args.length];

        //проходим по элеметам ком строки
        for (int i = 0, index = 0; i < args.length; i++) {
            //устанавливаем 0 эл-т, чтобы в цикле ниже не было npe
            if (index == 0) {
                uniqueStr[index] = args[i];
                index++;
                continue;
            }

            //флаг для пониамя необходимо ли соранять значение
            boolean isUnique = true;
            for (int j = 0; j < uniqueStr.length; j++) {
                //если строки равны - прерываем цикл
                if (args[i].equals(uniqueStr[j])) {
                    isUnique = false;
                    break;
                }
            }
            //если строка уникальна - сохраняем в выходной массив
            if(isUnique) {
                uniqueStr[index] = args[i];
                index++;
            }
        }

        //выводит только уникальные слова из переданной последовательности.
        for(String str : uniqueStr){
            if (str != null) {
                System.out.print(str + " ");
            }
        }
    }
}
