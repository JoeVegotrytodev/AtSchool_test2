package mod2les54.task3;

public class EntryPoint54_3 {
    public static void main(String[] args) {
        /*
Через аргумент командной строки передается строка.
Используя StringBuilder, напишите программу,
которая в переданной строке заменяет все нули на единицы и наоборот.
Остальные символы не должны изменится.
Выведите результирующую строку.
         */

        StringBuilder sourceString = new StringBuilder(args[0]);

        for(int i = 0; i < sourceString.length() - 1; i++){
            if(sourceString.charAt(i) == '0')
                sourceString.setCharAt(i, '1');
            else if (sourceString.charAt(i) == '1')
                sourceString.setCharAt(i, '0');
        }

        System.out.println(sourceString);
    }
}
