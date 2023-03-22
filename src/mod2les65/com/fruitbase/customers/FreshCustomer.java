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

    /**
     * Добаляет фрукт в массив заказа
     * @param fruitsArray массив в который доавбляем эл-т
     * @param fruit       доавбляемый фрукт
     * @param index       индекс в который ложим фрукт
     * @return массив с доавбленным эл-том
     */
    private Fruit[] addFreshFruitToPurchase(Fruit[] fruitsArray, Fruit fruit, int index) {
        //моно и напрямую в массив заказы добалдвять но и без того много исправить нужно......
        fruitsArray[index] = fruit;
        return fruitsArray;
    }

    /**
     * Добаляет фрукт в массив несвежих.
     * @param fruitsArray массив в который доавбляем эл-т
     * @param fruit       доавбляемый фрукт
     * @param index       индекс в который ложим фрукт
     * @return массив с доавбленным эл-том
     */
    private Fruit[] addUnfreshFruitToUnlikeArray(Fruit[] fruitsArray, Fruit fruit, int index) {
        fruitsArray[index] = fruit;
        return fruitsArray;
    }
}
