package mod4les4.task2.customers;

import mod4les4.task2.Delivery;
import mod4les4.task2.fruits.Fruit;
import java.util.Arrays;

public class UniqueCustomer extends Customer  {

    public UniqueCustomer(Fruit[] fruits, String name) {
        super(fruits, name);
        this.purchases = fruits;
        this.name = name;
    }

    public void takeFruits(Delivery cargo) {
        purchases = cargo.getFruits().clone();
//        для хранения уникальных продуктов
        Fruit[] uniqueFruits = new Fruit[1];
        //первый сохранили
        uniqueFruits[0] = purchases[0];
        //проходим по заказу
        for(int indexOfCargo = 1; indexOfCargo < purchases.length; indexOfCargo++){
            //проходим по уникальным фруктам
            for(int uniqueIndex = 0; uniqueIndex < uniqueFruits.length; uniqueIndex++){
                //если совпали фрукты
                if(purchases[indexOfCargo].getName().equals(uniqueFruits[uniqueIndex].getName())){
                    //то
                    cargo.removeFruit(purchases[indexOfCargo]);
                    unlikedFruits = addFruitToArray(unlikedFruits, purchases[indexOfCargo]);
                }
            }
            uniqueFruits = addFruitToArray(uniqueFruits, purchases[indexOfCargo]);
        }
        purchases = cargo.getFruits();
    }

    /**
     * Добаляет фрукт в массив фруктов расширяя массив.
     * @param fruitsArray массив в который доавбляем эл-т
     * @param fruit       доавбляемый фрукт
     * @return увеличенный на один элемент масси с новым фруктом
     */
    private Fruit[] addFruitToArray(Fruit[] fruitsArray, Fruit fruit) {
        Fruit[] newFruits = new Fruit[fruitsArray.length + 1];

        for(int index = 0; index < fruitsArray.length; index++){
            newFruits[index] = fruitsArray[index];
        }

        newFruits[newFruits.length - 1] = fruit;
        return newFruits;
    }
}
