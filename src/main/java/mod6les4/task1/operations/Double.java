package mod6les4.task1.operations;

import mod6les4.task1.Function;

//- у класса Double метод evaluate умножает полученный параметр на 2
public class Double implements Function {
    @Override
    public int evaluate(int number){
        return number * 2;
    }

    @Override
    public String toString() {
        return "double";
    }
}
