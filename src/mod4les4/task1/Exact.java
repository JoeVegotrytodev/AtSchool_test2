package mod4les4.task1;
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
