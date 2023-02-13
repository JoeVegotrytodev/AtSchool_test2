package mod2les54.task5;

public class EntryPoint54_5 {
    public static void main(String[] args) {
    /*
    С использованием этого метода напишите программу,
    которая проверяет является ли строка, переданная через аргументы командной строки,
    целым числом, и выводит результат проверки.
     */
     String sourceString = args[0];

     if(isInteger(sourceString))
         System.out.println("Строка является целым числом");
     else
         System.out.println("Строка не является целым числом");
    }

    /*
    Напишите метод "static boolean isInteger(String str)", который
    получает на вход строку и возвращает true, если строка str состоит
    только из цифр.
     */
    static boolean isInteger(String str){

        for(int i = 0; i < str.length(); i++){
            if(!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
