package mod5les5.task1;

public class Energy extends NatureElement {

    NatureElement connect(NatureElement elementToConnect){
        //обработку следующих формул:
        //    Energy + Water = Steam
        //    Water + Energy = Steam
        if(elementToConnect instanceof Water){
            Steam steam = new Steam();
            System.out.println(this + " + " + elementToConnect + " = " + steam);
            return steam;
        }
        else{
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public String toString() {
        return "Energy";
    }

}
