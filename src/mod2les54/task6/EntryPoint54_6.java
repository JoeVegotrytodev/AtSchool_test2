package mod2les54.task6;

import static java.lang.Math.pow;

public class EntryPoint54_6 {
    public static void main(String[] args){
        /*
        Напишите программу, которая получает строку через аргумент командной строки,
        проверяет можно ли преобразовать строку в целое число. Если
        переданная строка не может быть преобразована в целое число или
        получаемое число не cможет поместиться в диапазон int,
        то выводится сообщение об ошибке и программа завершается.
        Если может, то преобразуйте строку в целое число, используя метод toInt,
        и выведите результат умножения этого числа на 2.
         */

        //Напишите программу, которая получает строку через аргумент командной строки
        String str = args[0];

        //проверки строки, в первом случае подрезаем символы из строки
        //или не изменяем строку проверяем строку на наличие лищних символов
//        if (str.charAt(0) == '-' | str.charAt(0) == '+') {
//            String tempStr = str.substring(1);
//            if (!isInteger(tempStr)) {
//                System.out.println("В строке присутствуют лишние символы !");
//                return;
//            }
//        }
//        else{
//            String tempStr = str.substring(1);
//            if (!isInteger(tempStr)) {
//                System.out.println("В строке присутствуют лишние символы !");
//                return;
//            }
//        }

        if(!argumentCheck(str)) return;

        /*не понял немного как тут провреить, что строка больше чем значение.
        Сам наш метод toInt использовать не можем, класс Integer по услови не проходит,
        хотя оба ограничения ловит.
         */
//        char[] charArray = {2,1,4,7,4,8,3,6,4,8};
//        int count = 0;
//
//        for(int k = 0; k < str.length(); k++){
//            if(Character.getNumericValue(str.charAt(k)) >= Character.getNumericValue(charArray[k])){
//                count++;
//            }
//        }
//        if(count == charArray.length){
//            System.out.println("Слишком большое число для формата инт !");
//            return;
//        }

        System.out.println(toInt(str));
    }
    /*
    Реализуйте метод static int toInt(String str), который принимает в качестве аргумента
    строковое представление целого числа и возвращает его целочисленное значение.
    Результатом вызова toInt("-14") будет целое число -14. Или toInt("0012") вернет 12.
    Использовать Integer.parseInt, Integer.valueOf и подобные "готовые" методы нельзя.
    */
    public static int toInt(String str){
        //итогове число
        int resultNum = 0;
        //позиция элемента в строке, оставил тут а не в цикле фор, чтобы не усложнять цикл
        int position = 0;
        //флаг отрицательного числа
        boolean isPositive = str.charAt(0) != '-';

        //проверка отрицательное ли число

        //идем с конца строки
        for(int i = str.length() - 1; i >= 0; i--){
            //получаем число
            switch(str.charAt(i)){
                case '1' : {
                    //добавялем в сумму, учитывая порядок
                    resultNum = resultNum + (int)pow(10,position);
                    break;
                }
                case '2' : {
                    resultNum = resultNum + 2 * (int)pow(10,position);
                    break;
                }
                case '3' : {
                    resultNum = resultNum + 3 * (int)pow(10,position);
                    break;
                }
                case '4' : {
                    resultNum = resultNum + 4 * (int)pow(10,position);
                    break;
                }
                case '5' : {
                    resultNum = resultNum + 5 * (int)pow(10,position);
                    break;
                }
                case '6' : {
                    resultNum = resultNum + 6 * (int)pow(10,position);
                    break;
                }
                case '7' : {
                    resultNum = resultNum + 7 * (int)pow(10,position);
                    break;
                }
                case '8' : {
                    resultNum = resultNum + 8 * (int)pow(10,position);
                    break;
                }
                case '9' : {
                    resultNum = resultNum + 9 * (int)pow(10,position);
                    break;
                }
                case '0' :
                    break;
            }
            //позицию меняю отдельно
            position++;
        }
        //возврат значения числа учитывая знак
        return isPositive ? resultNum* 2 : -resultNum* 2;
    }

    //перетащил сюда проверку  из 5 задания  с корректировкой
    public static boolean isInteger(String str){
        for(int i = 0; i < str.length(); i++){
            if(!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static boolean argumentCheck(String argument){

        char[] charArray = {2,1,4,7,4,8,3,6,4,8};
        int count = 0;

        if (argument.charAt(0) == '-' | argument.charAt(0) == '+') {
            String tempStr = argument.substring(1);
            if (!isInteger(tempStr)) {
                System.out.println("В строке присутствуют лишние символы !");
                return false;
            }


            for(int k = 0; k < tempStr.length(); k++){
                if(Character.getNumericValue(tempStr.charAt(k)) >= Character.getNumericValue(charArray[k])){
                    count++;
                }
            }
            if(count == charArray.length){
                System.out.println("Слишком большое число для формата инт !");
                return false;
            }
        }
        else{
//            String tempStr = argument.substring(0);
            String tempStr = argument;
            if (!isInteger(tempStr)) {
                System.out.println("В строке присутствуют лишние символы !");
                return false;
            }

            for(int k = 0; k < tempStr.length(); k++){
                if(Character.getNumericValue(tempStr.charAt(k)) >= Character.getNumericValue(charArray[k])){
                    count++;
                }
            }
            if(count == charArray.length){
                System.out.println("Слишком большое число для формата инт !");
                return false;
            }
        }

        return true;
    }

    /* Неудачный вариант оставлю ниже
    static int toInt(String str)
        int currentPosition = 0;
        StringBuilder sb = new StringBuilder(str);

        //if(str.charAt(0) == '-') {
        if(str.startsWith("-")) {
            currentPosition += 1;
        }
        System.out.println("after - deleting " + currentPosition);


        if(str.indexOf('0') == currentPosition) {
            //System.out.println("curPos " + currentPosition);
            int zeros = currentPosition;
            while(str.charAt(zeros) == '0'){
                zeros++;
            }
            str = str.substring(zeros);
        }
        System.out.println("after 0 deleting \"" + str + "\"");


        char[] charArray = new char[str.length()];
        int j = 0;
        for(int i = currentPosition-1; i < str.length(); i++){
            charArray[j] = str.charAt(i);
            j++;
        }
        System.out.println(charArray);

        int result = 0;
        for(int i = 0; i < charArray.length; i++){
            Character.getNumericValue(charArray);
            Integer.parseInt(str);
        }
        System.out.println(charArray);
        return 1;
     */

}
