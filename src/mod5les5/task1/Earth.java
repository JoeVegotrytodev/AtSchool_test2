package mod5les5.task1;

public class Earth extends NatureElement {
    final private String name = "Earth";

    @Override
    NatureElement connect(NatureElement elementToConnect) {
        if(elementToConnect instanceof Earth){
            Pressure pressure = new Pressure();
            System.out.println(this + " + " + elementToConnect + " = " + pressure);
            return pressure;
        }
        else
        if(elementToConnect instanceof Fire){
            Lava lava = new Lava();
            System.out.println(this + " + " + elementToConnect + " = " + lava);
            return lava;
        }
        else if(elementToConnect instanceof Water){
            Mud mud = new Mud();
            System.out.println(this + " + " + elementToConnect + " = " + mud);
            return mud;
        }
        else if(elementToConnect instanceof Air){
            Dust dust = new Dust();
            System.out.println(this + " + " + elementToConnect + " = " + dust);
            return dust;
        }
        else{
            System.out.println("There is no new element ");
            return null;
        }
    }

    @Override
    public String toString() {
        return "Earth";
    }

    public String getName() {
        return name;
    }
}
