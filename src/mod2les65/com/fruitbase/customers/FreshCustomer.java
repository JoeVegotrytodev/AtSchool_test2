package mod2les65.com.fruitbase.customers;

import mod2les65.com.fruitbase.fruits.Fruit;

public class FreshCustomer extends Customer {

    public FreshCustomer(Fruit[] fruits, String name) {
        super(fruits, name);
        this.purchases = fruits;
        this.name = name;
    }

    //    реалиация метода takeFruits
    //    выбираются только свежие фрукты
    public void takeFruits() {
        //создаем массив для запоминания свежих фруктов
        Fruit[] freshFruits = new Fruit[getPurchases().length];
        //для записи фрукта в массив хранит текущее положение поледнего эл-та
        int freshFruitsIndex = 0;

        //проходим по всему массиву
        for (Fruit fruit : getPurchases()) {
            //прерываем если эл-тов нет в массиве еще,
            // можно через length сделать наверное, но зачем, если работает
            if (fruit == null)
                break;

            if (fruit.isFresh()) {
                purchases = addFreshFruitToPurchase(freshFruits, fruit, freshFruitsIndex);
                freshFruitsIndex++;
            } else {
                unlikedFruits = fruitsCopyAndPlusElement(unlikedFruits);
                unlikedFruits = addUnfreshFruitToUnlikeArray(unlikedFruits, fruit,unlikedFruits.length - 1);
            }
        }
    }
}
