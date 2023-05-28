package mod7les9.task1;

import mod7les9.task1.fruits.Apple;
import mod7les9.task1.fruits.Banana;
import mod7les9.task1.fruits.Fruit;
import mod7les9.task1.vegetables.Cucumber;
import mod7les9.task1.vegetables.Tomato;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class EntryPoint7_9 {
    public static void main(String[] args) {
        ArrayList<Plant> plantsList = new ArrayList<>(4);
        plantsList.add(new Apple());
        plantsList.add(new Banana());
        plantsList.add(new Tomato());
        plantsList.add(new Cucumber());

        ArrayList<Plant> multifruit  = plantsList.stream()
                .filter(plant -> plant instanceof Fruit)
                .collect(Collectors.toCollection(ArrayList::new));

        multifruit.forEach(System.out::println);
    }
}
