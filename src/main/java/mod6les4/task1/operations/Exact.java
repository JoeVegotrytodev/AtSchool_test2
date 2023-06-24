package mod6les4.task1.operations;

import mod6les4.task1.Function;

//- у класса Exact метод evaluate возвращет параметр без изменения
public class Exact implements Function {
    @Override
    public int evaluate(int number){
        return number;
    }

    @Override
    public String toString() {
        return "exact";
    }
}
