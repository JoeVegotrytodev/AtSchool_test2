package mod2les75.task3;

public class Element {
    private int number;

    public Element(int number) {
        this.number = number;
    }

//    Кроме того у этого класса переопределен метод finalize:
//    в теле метода выводится строка: Finalize , где number - значение внутреннего поля.
    @Override
    protected void finalize(){
        System.out.println("Finalize " + number);
    }

}
