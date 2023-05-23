package mod7les6.task2;

import mod7les6.task2.fruits.Apple;
import mod7les6.task2.fruits.Banana;
import mod7les6.task2.fruits.Fruit;
import mod7les6.task2.vegetables.Cucumber;
import mod7les6.task2.vegetables.Tomato;
import mod7les6.task2.vegetables.Vegetable;

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

        Basket<Fruit> fruitBasket = new Basket<>();
        fruitBasket.addItem(apple);
        fruitBasket.addItem(banana);

        Basket<Vegetable> vegetableBasket = new Basket<>();
        vegetableBasket.addItem(tomato);
        vegetableBasket.addItem(cucumber);

        makeSalad(fruitBasket);
        makeSalad(vegetableBasket);
    }
}
