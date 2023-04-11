package mod4les4.task1;
//- у класса Double метод evaluate умножает полученный параметр на 2
public class Double implements Function{
    @Override
    public int evaluate(int number){
        return number * 2;
    }

    @Override
    public String toString() {
        return "double";
    }
}
