package mod5les5.task1;

public class Pressure extends NatureElement {

    NatureElement connect(NatureElement elementToConnect){
        System.out.println("There is no new element to connect");
        return null;
    }

    @Override
    public String toString() {
        return "Pressure";
    }

}
