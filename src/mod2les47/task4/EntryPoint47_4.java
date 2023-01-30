package mod2les47.task4;

import java.lang.Math;

public class EntryPoint47_4 {
    //В основном классе программы объявлена и инициализиована целочисленная переменная n.
    int n = 19;

    public static void main(String[] args) {
        EntryPoint47_4 obj = new EntryPoint47_4();

        //Используя эти методы, напишите программу, которая генерит целые
        //числа до тех пор, пока не сгенерит простое число.
        for(;;){
            int randomNumber = obj.nextInt(obj.n);
            if(obj.isPrime(randomNumber)){
                System.out.println(randomNumber);
                break;
            }
        }
    }

    //Реализуйте метод boolean isPrime(int x), который возвращает true, если x - простое число.
    boolean isPrime(int number){
        //ввел такое условие, т.к. 0  и 1 не простые числа, но и не составные
        if(number != 0 & number != 1){
            for (int divider = 2; divider < number; divider++) {
                if (number % divider == 0) return false;
            }
            return true;
        }
        else return false;
    }

    //Реализуйте метод int nextInt(int x),
    //который возвращает случайно сгенерированное целое число от 0 до x, x не включая.
    int nextInt(int number){
        int randomNumber = (int)(Math.random() * 100);

        while(randomNumber > number) randomNumber = (int)(Math.random() * 100);

        return randomNumber;
    }
}
