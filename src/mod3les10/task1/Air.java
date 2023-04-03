package mod3les10.task1;

public class Air extends NatureElement {
    final private String name = "Air";

    @Override
    NatureElement connect(NatureElement elementToConnect) {
        if(elementToConnect instanceof Air){
            Pressure pressure = new Pressure();
            System.out.println(this + " + " + elementToConnect + " = " + pressure);
            return pressure;
        }
        else
        if(elementToConnect instanceof Fire){
            Energy energy = new Energy();
            System.out.println(this + " + " + elementToConnect + " = " + energy);
            return energy;
        }
        else if(elementToConnect instanceof Water){
            Rain rain = new Rain();
            System.out.println(this + " + " + elementToConnect + " = " + rain);
            return rain;
        }
        else if(elementToConnect instanceof Earth){
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
        return "Air";
    }

    public String getName() {
        return name;
    }
}
