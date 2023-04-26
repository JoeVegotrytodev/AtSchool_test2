package mod6les4.task1;

//- у класса Square метод evaluate возвращет параметр, умноженный на сам себя
public class Square implements Function {
    @Override
    public int evaluate(int num){
        return num * num;
    }

    @Override
    public String toString() {
        return "square";
    }
}
