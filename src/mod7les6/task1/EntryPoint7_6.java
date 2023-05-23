package mod7les6.task1;

import mod7les6.task1.fruits.Apple;
import mod7les6.task1.fruits.Banana;
import mod7les6.task1.fruits.Fruit;
import mod7les6.task1.vegetables.Cucumber;
import mod7les6.task1.vegetables.Tomato;
import mod7les6.task1.vegetables.Vegetable;

public class EntryPoint7_6 {
    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit banana = new Banana();
        Vegetable tomato = new Tomato();
        Vegetable cucumber = new Cucumber();

        Basket<Fruit> fruitBasket = new Basket<>();
        fruitBasket.addItem(apple);
        fruitBasket.addItem(banana);
        fruitBasket.printBasket();
        System.out.println();

        Basket<Vegetable> vegetableBasket = new Basket<>();
        vegetableBasket.addItem(tomato);
        vegetableBasket.addItem(cucumber);
        vegetableBasket.printBasket();

    }
}
