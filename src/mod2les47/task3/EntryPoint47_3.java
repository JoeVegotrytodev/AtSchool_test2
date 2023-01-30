package mod2les47.task3;

public class EntryPoint47_3 {
    public static void main(String[] args) {
        //Проверку на наличие аргументов делать не надо.
        //Сделайте проверку, что n больше или равно 1, а m больше 0.
        //В противном случае выведите сообщение об ошибке
        //и завершите программу.
        if((Integer.parseInt(args[0]) < 0) | (Integer.parseInt(args[1]) < 0)) {
            System.out.println("args are less than zero");
            return;
        }

        //Используя реализованный метод, напишите программу, которая через
        //аргументы командной строки получает целочисленные значения n и col,
        //а затем печатает соответствующего размера змейку.
        shakePrint(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
    }
    //Напишите метод snakePrint(int n, int col),
    //который выводит числа "змейкой" от 1 до n:
    //Выводимые числа разделены пробелами. - по условию пробелы , но с табуляцией красивее
    static void shakePrint(int n, int col){
        for(; col != 0; col--) {
            for (int i = n; i != 0; i--) System.out.print(i * col + "\t");
            System.out.println();
        }
    }
}
