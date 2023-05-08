package mod6les4.task1.operations;

import mod6les4.task1.Function;

//- у класса Square метод evaluate возвращет параметр, умноженный на сам себя
public class Square implements Function {
    @Override
    public int evaluate(int number){
        return number * number;
    }

    @Override
    public String toString() {
        return "square";
    }
}
