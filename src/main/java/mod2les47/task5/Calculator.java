package mod2les47.task5;

public class Calculator {

    // - int add(int x, int y) - выполнение x + y
    int add(int x, int y){
        return x + y;
    }

    // - int sub(int x, int y) - выполнение x - y
    int sub(int x, int y){
        return x - y;
    }

    // - int mult(int x, int y) - выполнение x * y
    int mult(int x, int y){
        return x * y;
    }

    //- int divide(int x, int y) - выполнение x / y. Имеет проверку y == 0 или нет.
    // Если равно, то пишется сообщение, что операция не может быть выполнена,
    // и программа завершается, используя System.exit(0);
    int divide(int x, int y){
        if (y == 0){
            System.out.println("Program can't be run...");
            System.exit(0);
        }
        return x / y;
    }
}
