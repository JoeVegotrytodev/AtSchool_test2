package mod7les9.task2;

import mod7les9.task2.fruits.Apple;
import mod7les9.task2.fruits.Banana;
import mod7les9.task2.vegetables.Cucumber;
import mod7les9.task2.vegetables.Tomato;

import java.util.*;
import java.util.function.BiConsumer;

public class EntryPoint7_9 {

    public static void main(String[] args) {
        ArrayList<Plant> arrayPlants = new ArrayList<>(5);
        Basket<Plant> plantBasket = new Basket<>();

        addPlantsToCollection(arrayPlants);
//        arrayPlants.forEach((s) -> System.out.println(s.toString() + " " + s.getClass().getSimpleName())); System.out.println("- - - - - - - -");

        addPlantsToHMap(plantBasket, arrayPlants);
        plantBasket.printBasket();
        System.out.println("\nBasket size is : " + plantBasket.getSize());
    }

    static void addPlantsToCollection(ArrayList<Plant> collection){
        BiConsumer<ArrayList<Plant>, Plant> addElement = ArrayList::add;

        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            switch (random.nextInt(4)){
                case 0 : {
                    addElement.accept(collection, new Apple());
                    break;
                }
                case 1 : {
                    addElement.accept(collection, new Banana());
                    break;
                }
                case 2 : {
                    addElement.accept(collection, new Tomato());
                    break;
                }
                case 3 : {
                    addElement.accept(collection, new Cucumber());
                    break;
                }
            }
        }
    }

    static void addPlantsToHMap(Basket<Plant> basket, ArrayList<Plant> collection){
        BiConsumer<String, Plant> addItem = basket.getBasket()::put;

        collection.clear();
        //как в хэшсет добавлять несколько одинаковый объектов
        Cucumber cucumber = new Cucumber();
        Tomato tomato = new Tomato();

        collection.add(cucumber);
        collection.add(cucumber);
        collection.add(cucumber);
        collection.add(tomato);
        collection.add(tomato);

        collection.forEach((listValue) -> addItem.accept(listValue.toString(), listValue));
    }
}
