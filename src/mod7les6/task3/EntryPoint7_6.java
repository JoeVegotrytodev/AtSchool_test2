package mod7les6.task3;

import mod7les6.task3.fruits.Apple;
import mod7les6.task3.fruits.Banana;
import mod7les6.task3.vegetables.Cucumber;
import mod7les6.task3.vegetables.Tomato;

import java.util.*;
import java.util.function.BiConsumer;

public class EntryPoint7_6 {

    public static void main(String[] args) {
        ArrayList<Plant> arrayPlants = new ArrayList<>(5);
        Basket<Plant> plantBasket = new Basket<>();

        addPlantsToCollection(arrayPlants);
        arrayPlants.forEach((s) -> System.out.println(s.toString() + " " + s.getClass().getSimpleName()));

        System.out.println("- - - - - - - -");

        addPlantsToHMap(plantBasket, arrayPlants);
        //переделал на лямбду и forEach в методе printBasket
        plantBasket.printBasket();
    }

    static void addPlantsToCollection(ArrayList<Plant> collection){
        BiConsumer<ArrayList<Plant>, Plant> addElement = ArrayList::add;

        addElement.accept(collection, new Apple());
        addElement.accept(collection, new Banana());
        addElement.accept(collection, new Tomato());
        addElement.accept(collection, new Cucumber());
//        for (int i = 0; i < 5; i++) {
//            Random random = new Random();
//            switch (random.nextInt(4)){
//                case 0 : {
//                    addElement.accept(collection, new Apple());
//                    break;
//                }
//                case 1 : {
//                    addElement.accept(collection, new Banana());
//                    break;
//                }
//                case 2 : {
//                    addElement.accept(collection, new Tomato());
//                    break;
//                }
//                case 3 : {
//                    addElement.accept(collection, new Cucumber());
//                    break;
//                }
//            }
//        }
    }

    static void addPlantsToHMap(Basket<Plant> basket, ArrayList<Plant> collection){
        BiConsumer<String, Plant> addItem = basket.getBasket()::put;

        basket.getBasket().clear();
        collection.forEach((listValue) -> addItem.accept(listValue.toString(), listValue));

//        2ой вариант. Тут  не получилось, дальше выдумывать начал
//        basket.getKeys().forEach((s) -> {
//            Random random = new Random();
//            switch (random.nextInt(4)){
//                case 0 : {
//                    addItem.accept(s, new Apple());
//                    break;
//                }
//                case 1 : {
//                    addItem.accept(s, new Banana());
//                    break;
//                }
//                case 2 : {
//                    addItem.accept(new Tomato().toString(), new Tomato());
//                    break;
//                }
//                case 3 : {
//                    addItem.accept(new Cucumber().toString(), new Cucumber());
//                    break;
//                }
//            }
//        });

//        1ый вариант был, он работает, но нужен-то For each по заданию
//        for (int i = 0; i < 5; i++) {
//            Random random = new Random();
//            switch (random.nextInt(4)){
//                case 0 : {
//                    addItem.accept(basket, new Apple());
//                    break;
//                }
//                case 1 : {
//                    addItem.accept(basket, new Banana());
//                    break;
//                }
//                case 2 : {
//                    addItem.accept(basket, new Tomato());
//                    break;
//                }
//                case 3 : {
//                    addItem.accept(basket, new Cucumber());
//                    break;
//                }
//            }
//        }
    }
}
