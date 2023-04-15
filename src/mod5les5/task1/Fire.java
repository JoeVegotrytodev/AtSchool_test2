package mod5les5.task1;

public class Fire extends NatureElement {

    final private String name = "Fire";

//    эти классы содержат метод connect,
//    который на вход получает другой NatureElement
//    В теле метода происходит проверка какого типа передан элемент и в соответствие со схемой
//    печатается формула:
//           <текущий элемент> + <переданный элемент> = <результирующий элемент>
//    И также создается объект результирующего элемента и возвращается.
//    Если по схеме нет нового элемента, то выводится сообщение "Нет нового элемента"
//    и возвращается null.
    @Override
    NatureElement connect(NatureElement elementToConnect) {
//        if(elementToConnect instanceof Fire){
//            System.out.println(this + " + " + elementToConnect + " = " + this);
//            return new Fire();
//        }
//        else
            if(elementToConnect instanceof Water){
            Steam steam = new Steam();
            System.out.println(this + " + " + elementToConnect + " = " + steam);
            return steam;
        }
        else if(elementToConnect instanceof Air){
            Energy energy = new Energy();
            System.out.println(this + " + " + elementToConnect + " = " + energy);
            return energy;
        }
        else if(elementToConnect instanceof Earth){
            Lava lava = new Lava();
            System.out.println(this + " + " + elementToConnect + " = " + lava);
            return lava;
        }
        else{
                throw new UnsupportedOperationException();
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Fire";
    }
}
