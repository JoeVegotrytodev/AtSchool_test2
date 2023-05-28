package mod7les6.task3;

import mod7les6.task3.fruits.Apple;
import mod7les6.task3.fruits.Banana;
import mod7les6.task3.vegetables.Cucumber;
import mod7les6.task3.vegetables.Tomato;

import java.util.*;
import java.util.function.BiConsumer;

public class EntryPoint7_6 {

    private static void makeSalad(Basket someBasket){
        System.out.println("```\n" +
                "Готовим салатик:\n" +
                "Режем - тут должно быть столько же фруктов, сколько было элементов в корзинеi");

        someBasket.printBasket();

        System.out.println("Угощайся!\n" +
                "```");
    }

    public static void main(String[] args) {
        ArrayList<Plant> arrayPlants = new ArrayList<>(5);
        Basket<Plant> plantBasket = new Basket<>();

        //генерит только эелменты по разному , ведь ключ - название элемента по условию
        addPlantsToHMap(plantBasket);
        plantBasket.printBasket();

        System.out.println(" - - - ");

        addPlantsToCollection(arrayPlants);
        arrayPlants.forEach((s) -> System.out.println(s.toString()));
    }

    static void addPlantsToCollection(ArrayList collection){
        BiConsumer<ArrayList, Plant> addElement = ArrayList::add;

        collection.forEach((plant) -> {
            Random random = new Random();
            switch (random.nextInt(4)){
                case 0 : {
                    plant = new Apple();
                    collection.add(plant);
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
        });
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

    static void addPlantsToHMap(Basket basket){
        BiConsumer<Basket, Plant> addItem = (Basket, Plant) -> basket.addItem(Plant);
        System.out.println("- - -");

        basket.getKeys().forEach((s) -> {
            Random random = new Random();
            switch (random.nextInt(4)){
                case 0 : {
                    addItem.accept(basket, new Apple());
                    break;
                }
                case 1 : {
                    addItem.accept(basket, new Banana());
                    break;
                }
                case 2 : {
                    addItem.accept(basket, new Tomato());
                    break;
                }
                case 3 : {
                    addItem.accept(basket, new Cucumber());
                    break;
                }
            }
        });
        basket.printBasket();
        System.out.println("- - -");
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
