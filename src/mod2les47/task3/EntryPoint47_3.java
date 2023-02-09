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
    //Выводимые числа разделены пробелами. - по условию пробелы , но с табуляцией красивеt


    static void shakePrint(int n, int col) {
        //строка для вывода. Добавил чтобы сделать вывод в обратном порядке
        StringBuilder line = new StringBuilder();
        //переменная хрнаящее число для вывода
        int currentNumber = 1;
        //переменная определяющая следует ли разворачивать строку
        boolean reverseLine = true;

        //пока не выведены все числа
        for (; currentNumber <= n; ) {
            //для каждой строки
            for (int i = 0; i < col; i++) {
                //сохраняем значение в строку
                line.append(currentNumber++);
                //добавялем разделитель
                line.append('\t');
                //если это последнее число, то выходим из цикла
                if (currentNumber == n + 1) break;
            }
            //через строку будет разворот строки
            reverseLine = !reverseLine;
            //сам разворот
            if (reverseLine) {
                //индекс для получения эл-та строки
                int startIndex = 0;
                //создаем строку, которую будем резать а не саму line
                String str = line.substring(0);
                //тут строка полсе именения
                String cuttedStr = "";
                //счетчик для форматирования вывода, когда элементы
                // строки при обратном выводе не заполняют всю стркоу
                int counter = 0;

                //пока в строке присутвуют символы табуляции
                while (str.indexOf('\t') != -1) {
                    //эл-т который будем вырезать огарничен табуляцией
                    int endIndex = str.indexOf("\t");
                    //получаем число и добавляем уже вырезанные числа
                    cuttedStr = str.substring(startIndex, endIndex) + "\t" + cuttedStr;
                    //удаляем из строки уже полученный элемент
                    str = str.substring(endIndex + 1);
                    //запоминаем сколько чисел в строку положили
                    counter++;
                }

                //если получили меньше эл-ов чем столбцов
                for (; counter < col; counter++) {
                    //заполянем табуляцией
                    cuttedStr = "\t" + cuttedStr;
                }
                //когда строку получили, перезатираем ту, которую выводим
                line.delete(0, line.length());
                line.append(cuttedStr);
            }
            //вывод получившейся строки
            System.out.println(line);
            //обнуляем строку для записи новых значений
            line.delete(0, line.length());
        }
    }
}
