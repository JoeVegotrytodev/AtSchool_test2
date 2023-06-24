package mod4les4.task1;

import java.util.Arrays;
import java.util.Locale;

public class EntryPoint4_1 {
    /*Напишите в отдельном классе программу, которая через аргументы командной строки
получает последовательность целых чисел и название операции, которую надо применить числам.
При выполнении печатается исходная последовательность чисел, а потом печатается последовательность,
полученная применением операции к числам.
Название операции передается первым аргументом, а далее передаются числа.
Название операции соответствует названиям классов Half, Double, Exact, Square.
 */
    public static void main(String[] args) {
        EntryPoint4_1 ep = new EntryPoint4_1();

        ep.isInputValid(args);
        System.out.println(Arrays.toString(args));

        switch(args[0].toLowerCase(Locale.ROOT)){
            case "double" : ep.applyFunction(ep.toInt(args), new Double());
                 break;
            case "exact" : ep.applyFunction(ep.toInt(args), new Exact());
                break;
            case "half" : ep.applyFunction(ep.toInt(args), new Half());
                break;
            case "square" : ep.applyFunction(ep.toInt(args), new Square());
                break;
        }

    }

    /*
    Для реализации программы создайте метод applyFunction, который на вход получает два аргумента:
- массив из переданных чисел
- объект типа Function.
Этот метод возвращает новый массив, где каждый элемент является результатом применения
метода evaluate объякта типа Function к соответствующему элементу исходного массива.
     */
    private int[] applyFunction(int[] numbers, Function function){
        int[] result = new int[numbers.length];

        for(int index = 0; index < numbers.length; index++){
            result[index] = function.evaluate(numbers[index]);
        }

        System.out.println(Arrays.toString(result));
        return result;
    }

    /**
     *проверяет соотвествует ли требования входной массив
     * @param input - массив для проверки
     */
    private void isInputValid(String[] input){

        //- Если не передано название операции, то программа завершается с соответствующим сообщением об ошибке.
        try{
//            input[0] = input[0];
            if(input.length == 0)
                throw new ArrayIndexOutOfBoundsException();
        }
        catch(ArrayIndexOutOfBoundsException exc){
            System.out.println(" не передано название операции");
            System.exit(0);
        }

        //не заметил как-то этого момента
        String firstArgument = input[0].toLowerCase(Locale.ROOT);
        //- Если передано неподдерживаемое название класса, то программа завершается с соответствующим сообщением.
        if(!((firstArgument.equals(new Double().toString())) |
                (firstArgument.equals(new Exact().toString())) |
                (firstArgument.equals(new Half().toString())) |
                (firstArgument.equals(new Square().toString())))){

            System.out.println("Операция " + firstArgument + " не поддерживается");
            System.exit(0);
        }

        //- Если не передано хотя бы одно число, то программа завершается, с соответствующим сообщением об ошибке.
        try{
           //лямбу решил использовать из интереса, ведь более нигде не понадобится этот метод
            IsNum isNum = (String string) -> {
                for(int i = 0; i < string.length() - 1; i++){
                    if(!Character.isDigit(string.charAt(i))){
                        throw new NumberFormatException();
                    }
                }
                return true;
            };
            //проверяем что второй элемент передан
            if (input.length <= 1)
                throw new ArrayIndexOutOfBoundsException();
            //вопрос у меня почему по имени метода нельзя тут вызвать isNum ?
            else
                isNum.isNum(input[1]);
        }
        catch(ArrayIndexOutOfBoundsException | NumberFormatException exc){
            System.out.println("Не переданы числа для операции.");
            System.exit(0);
        }
    }

    //приводим строки к числам
    private int[] toInt(String[] args){
        int[] intArray = new int[args.length - 1];

        for(int index = 1; index < args.length; index++){
            intArray[index - 1] = Integer.parseInt(args[index]);
        }

        return intArray;
    }
}
