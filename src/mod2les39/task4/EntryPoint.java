package mod2les39.task4;

import mod2les31.Task4.*;

public class EntryPoint {
    public static void main(String[] args) {
        System.out.println(Animal.planet);
        Animal.planet = "Moon";

        Cat barsik = new Cat();
        System.out.println(barsik.planet);
    }
}
