package mod2les54.task4;

public class EntryPoint54_4 {
    public static void main(String[] args) {
        /*
        Через аргумент командной строки передается строка.
Используя StringBuilder, напишите программу, которая в переданной строке удаляет из неё всё, кроме цифр.
Выведите результирующую строку.
         */
        //получаем строку из аргумента
        StringBuilder sourceString = new StringBuilder(args[0]);

        //цикл по строке
        for(int i = 0; i < sourceString.length(); i++){
            //если символ не число
            if(!Character.isDigit(sourceString.charAt(i))){
                //удаляем
                sourceString.deleteCharAt(i);
                //изменяем индекс, чтобы не пропустить эл-т строки
                i--;
            }
        }

        System.out.println(sourceString);
    }
}
