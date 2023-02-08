package mod2les47.task5;

public class EntryPoint47_5 {
    public static void main(String[] args) {
        /*Используя класс Calculator, напишите программу, которая будет
        получать через аргументы командной строки два целых числа,
        знак операции и после этого выводить результат операции.
        через аргументы командной строки.

        Для проверки знака операции используйте оператор switch.
        Если введена неподдерживаемая операция,
        то выводить список поддерживаемых операций и завершать программу.*/

        //получаем аргументы ком строки
        int number1 = Integer.parseInt(args[0]), number2 = Integer.parseInt(args[2]);
        //String operation = args[2]; - используется лишь однажды, поэтому решил не вводить переменную

        //создаем экзмепляр калькулятора
        Calculator calc = new Calculator();

        switch(args[1]){
            case "+" :
                System.out.println(calc.add(number1, number2)); break;
            case "-" :
                System.out.println(calc.sub(number1, number2)); break;
            case "*" :
                System.out.println(calc.mult(number1, number2)); break;
            case "/" :
                System.out.println(calc.divide(number1, number2)); break;
            default:
                System.out.println("Operation not supported, please use one of next: +, -, *, /");
        }
    }
}
