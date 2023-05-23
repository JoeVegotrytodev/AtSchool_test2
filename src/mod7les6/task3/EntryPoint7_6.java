package mod7les6.task3;

import mod7les6.task3.fruits.Apple;
import mod7les6.task3.fruits.Banana;
import mod7les6.task3.fruits.Fruit;
import mod7les6.task3.vegetables.Cucumber;
import mod7les6.task3.vegetables.Tomato;
import mod7les6.task3.vegetables.Vegetable;

import java.util.ArrayList;
import java.util.HashMap;

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
        Fruit apple = new Apple();
        Fruit banana = new Banana();
        Vegetable tomato = new Tomato();
        Vegetable cucumber = new Cucumber();

        ArrayList<Plant> arrayPlants = new ArrayList<>(5);
        arrayPlants.add(apple);
        arrayPlants.add(banana);
        arrayPlants.add(tomato);
        arrayPlants.add(cucumber);
        arrayPlants.add(new Tomato());

        Basket<Plant> plantBasket = new Basket<>();
        plantBasket.addItem(apple);
        plantBasket.addItem(banana);
        plantBasket.addItem(tomato);
        plantBasket.addItem(cucumber);
        plantBasket.addItem(banana);

        plantBasket.printBasket();
    }
}
