package mod6les4.task1.operations;

import mod6les4.task1.Function;

//- у класса Half метод evaluate делит полученный параметр на 2
public class Half implements Function {
    @Override
    public int evaluate(int number){
        return number / 2;
    }

    @Override
    public String toString() {
        return "half";
    }
}
