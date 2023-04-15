package mod5les5.task1;

public class Water extends NatureElement {
    final private String name = "Water";

    @Override
    NatureElement connect(NatureElement elementToConnect) {
        if(elementToConnect instanceof Water){
            Sea sea = new Sea();
            System.out.println(this + " + " + elementToConnect + " = " + sea);
            return sea;
        }
        else
        if(elementToConnect instanceof Fire){
            Steam steam = new Steam();
            System.out.println(this + " + " + elementToConnect + " = " + steam);
            return steam;
        }
        else if(elementToConnect instanceof Air){
            Rain rain = new Rain();
            System.out.println(this + " + " + elementToConnect + " = " + rain);
            return rain;
        }
        else if(elementToConnect instanceof Earth){
            Mud mud = new Mud();
            System.out.println(this + " + " + elementToConnect + " = " + mud);
            return mud;
        }
        else if(elementToConnect instanceof Energy){
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
        return "Water";
    }

    public String getName() {
        return name;
    }
}
