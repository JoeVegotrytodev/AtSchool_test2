package mod7les9.task1;

import mod7les9.task1.fruits.Apple;
import mod7les9.task1.fruits.Banana;
import mod7les9.task1.fruits.Fruit;
import mod7les9.task1.vegetables.Cucumber;
import mod7les9.task1.vegetables.Tomato;

import java.util.ArrayList;

public class EntryPoint7_9 {
    public static void main(String[] args) {
        ArrayList<Plant> plantsList = new ArrayList<Plant>(4);
        ArrayList<Fruit> multifruit  = new ArrayList<>(2);
        plantsList.add(new Apple());
        plantsList.add(new Banana());
        plantsList.add(new Tomato());
        plantsList.add(new Cucumber());


        plantsList.stream().
                filter((plants) ->{
                    System.out.println("Hi there");
                    if(plants instanceof Fruit)
                        multifruit.add((Fruit) plants);
                    System.out.println("plantsList : " + plantsList);
                    System.out.println("multiftuit : " + multifruit);
                    return false;
        });
    }
}
