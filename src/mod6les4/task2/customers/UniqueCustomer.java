package mod6les4.task2.customers;

import mod6les4.task2.customers.Customer;
import mod6les4.task2.fruits.Fruit;

import java.io.Serializable;
import java.util.Arrays;

public class UniqueCustomer extends Customer {

    public UniqueCustomer(Fruit[] fruits, String name) {
        super(fruits, name);
        this.purchases = fruits;
        this.name = name;
    }

//    реалиация метода takeFruits отбирает только уникальные фрукты,
//    т.е. те, которых еще нет во внутреннем массиве
    public void takeFruits() {
        //массив для хранения фруктов-дублей. Не заметил в условии, что нужно удалять из карго фрукты
        // и вместо вызова метода ремув просто сохранял сюда...
        Fruit[] existedFruit = new Fruit[1];
        //массив хранения уникальных фруктов
        //так как покупки содержит массив всех фруктов, на ходу перезаписывать его не хотел
        //во время цикла, поэтому сохранял в отдельный массив
        Fruit[] uniqueFruits = new Fruit[0];

        //проходим по массиву заказа
        for (int indexOfPurchases = 0; indexOfPurchases < purchases.length; indexOfPurchases++) {
            //обнуляем флаг показывающий наличие дублей
            boolean isUnique = true;
            //проходим по имеющимся у покупателя фруктам
            for (int indexOfExist = 0; indexOfExist < existedFruit.length; indexOfExist++) {

                //первый фрукт заказа сохраняем сразу в существующие фрукты покупателя
                // для обращения в цикле к эл-ту массива, чтобы сравнивать мог с фруктом, а не с null
                if (indexOfPurchases == 0) {
                    //и этот код бы вынес в отдельный метод, но массив объявлен только в методе
                    // в отличие от массива ниже область видимо у него ограничена
                    existedFruit[0] = purchases[0];
                    //вынес в другой метод сохранение в массив неподходящий фруктов.
                    elementSaveToUnlikedArray(purchases[0]);
                    //и прерваем цикл, ибо не с чем сравнивать первый элемент
                    break;
                }

                //если фрукт из заказа совпал с имеющиммся фруктом - то есть фрукт дубль нашли
                if (purchases[indexOfPurchases].getName().equals(existedFruit[indexOfExist].getName())) {

                    //если это совпадение с первым фруктом заказа
                    //опять бы вынес в отдельный метод - но тут меняются поля метода
                    //которые из другого метода не бдуь доступны
                    if (indexOfPurchases == 1 && existedFruit[0].getName().equals(purchases[1].getName())) {
                        //отмечаем, что фрукт не уникален
                        isUnique = false;
                        //то прерываеми, потому что первый фрукт мы выше уже сохранили в массив неподходящих фруктов
                        //а если сохранять тут то появлялись лишние записи и проблемы с NPE
                        break;
                    }

                    //если же элемент является дубем и при этом не совпал с первым фруктом
                    //то сохраняем его в неподхяодище фрукты
                    elementSaveToUnlikedArray(purchases[indexOfPurchases]);
                    //отмечаем не уникальным
                    isUnique = false;
                    //раз уже понятно, что это дубль, то и смысла дальше сравнивать этот фрукт нет
                    break;
                }
            }
            //если же фрукт уникален и не было ни одного совпадения
            if (isUnique) {
                //сохраняем его в массив уникальных фруктов
                uniqueFruits = fruitsCopyAndPlusElement(uniqueFruits);
                uniqueFruits = addFruitToArray(uniqueFruits,
                        purchases[indexOfPurchases], uniqueFruits.length - 1);

                //если это не первый фрукт, то
                if (purchases[indexOfPurchases].getName().equals(existedFruit[0].getName()))
                    continue;

                //сохраняем фрукт в массив дублей, чтобы можно было с ним сравнивать последующие фрукты
                //(так как первый фрукт присутсвует в это массиве уже)
                existedFruit = fruitsCopyAndPlusElement(existedFruit);
                existedFruit = addFruitToArray(existedFruit,
                        purchases[indexOfPurchases], existedFruit.length - 1);
            }
        }
        //сохраняем полученный массив уникальных фруктов в поле заказ покупателя
        purchases = uniqueFruits;
        unlikedFruits = Arrays.copyOfRange(unlikedFruits, 1, unlikedFruits.length);
    }

    /**
     * Добаляет фрукт в массив фруктов.
     * @param fruitsArray массив в который доавбляем эл-т
     * @param fruit       доавбляемый фрукт
     * @param index       индекс в который ложим фрукт
     * @return массив с доавбленным эл-том
     */
    private Fruit[] addFruitToArray(Fruit[] fruitsArray, Fruit fruit, int index) {
        fruitsArray[index] = fruit;
        return fruitsArray;
    }

    /**
     * Сохраняет полученный фрукт в массив фруктов, которые не подошли киенту
     * @param firstFruit фрукт который сохраняем
     */
    private void elementSaveToUnlikedArray(Fruit firstFruit){
        unlikedFruits = fruitsCopyAndPlusElement(unlikedFruits);
        unlikedFruits = addFruitToArray(unlikedFruits,
                firstFruit, unlikedFruits.length - 1);
    }



}
