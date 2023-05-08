package mod5les5.task1.elements;

public class Sea extends NatureElement {

    public NatureElement connect(NatureElement elementToConnect){
//        System.out.println("There is no new element to connect");
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return "Sea";
    }

}
