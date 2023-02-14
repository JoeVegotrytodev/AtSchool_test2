package mod2les58.task2;

public class EntryPoint58_2 {
    public static void main(String[] args) {
        /*
        Через аргументы командной строки передаются "слова" -
        последовательность строчных латинских букв и цифр.
        Каждый аргумент - отдельное "слово".
         */
        //Сделайте проверку на наличие аргументов командной строки.
        try {
            if (args[0] == null) {
                System.out.println("аргументы не переданы");
                return;
            }
        } catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println("аргументы не переданы");
            return;
        }

        /*
        Сделайте проверку, что "слова" состоят только из строчных
        латинских букв и цифр.Иначе выведите сообщение об ошибке и
        завершите программу.
         */
        //проходим по словам
        for (String str : args) {
            //по символам
            for (int i = 0; i < str.length(); i++) {
                //если символ не число и не буква
                if(!Character.isDigit(str.charAt(i))
                        & !Character.isAlphabetic(str.charAt(i))) {
                    System.out.println("Некорректные символы");
                    return;
                }
            }
        }

        //Напишите программу, которая выводит слова наибольшей длины.
        int maxLength = 0;
        //ищем наибольую длину слова
        for (String str : args){
            if(str.length() > maxLength){
                maxLength = str.length();
            }
        }
        //выводим слова наибольшей длины
        for (String str : args){
            if(str.length() == maxLength){
                System.out.print(str + " ");
            }
        }
    }
}
