package mod2les65.com.fruitbase.customers;

import mod2les65.com.fruitbase.fruits.Fruit;

public class UniqueCustomer extends Customer {

    public UniqueCustomer(Fruit[] fruits, String name) {
        super(fruits, name);
        this.purchases = fruits;
        this.name = name;
    }

//    реалиация метода takeFruits отбирает только уникальные фрукты,
//    т.е. те, которых еще нет во внутреннем массиве
    public void takeFruits() {
        //массив для хранения фруктов-дублей
        Fruit[] existedFruit = new Fruit[1];
        //массив хранения уникальных фруктов
        Fruit[] uniqueFruits = new Fruit[0];

        //проходим по массиву заказа
        for (int indexOfPurchases = 0; indexOfPurchases < purchases.length; indexOfPurchases++) {
            //обнуляем наличие дублей
            boolean isUnique = true;
            //проходим по уже имеющимся у покупателя фруктам
            for (int indexOfExist = 0; indexOfExist < existedFruit.length; indexOfExist++) {

                //первый фрукт заказа сохраняем сразу в существующий фрукты для обращения в цикле
                if(indexOfPurchases == 0){
                    existedFruit[0] = purchases[0];
//                    System.out.println("Array in iskl " + Arrays.toString(existedFruit));
                    break;
                }
//                System.out.println("indexOfPurchases " + indexOfPurchases + ". purchase " + purchases[indexOfPurchases].getName());
//                System.out.println("indexOfExist " + indexOfExist + ". exist " + existedFruit[indexOfExist].getName());

                //если фрукт заказа совпал с имеющиммся фруктом
                if (purchases[indexOfPurchases].getName().equals(existedFruit[indexOfExist].getName())) {

//                    System.out.println("match___");
                    //если это совпадение с первым фруктом заказа
                    if(indexOfPurchases == 1 && existedFruit[0].getName().equals(purchases[1].getName())){
//                        System.out.println("Array in iskl " + Arrays.toString(existedFruit));
//                        System.out.println("iskluchenie");
                        isUnique = false;
                        //то пропускаем все операции,потому что первый фрукт мы выше уже сохранили как существующий
                        break;
                    }

//                    System.out.println(existedFruit.length);

//                    System.out.println("Array before " + Arrays.toString(existedFruit));
                    // еслине первый, то расширяем массив сущствующих фруктов
                    existedFruit = fruitsCopyAndPlusElement(existedFruit);
                    //и последний эл-ом в него кидаем найденный дуюлирующий фрукт
                    existedFruit = addExistedFruitToUnlikeArray(existedFruit,
                            purchases[indexOfPurchases], existedFruit.length - 1);
                    //и запоминаем это
                    isUnique = false;
//                    System.out.println(existedFruit.length);
//                    System.out.println("Array after " + Arrays.toString(existedFruit));
                    //после чего нет смысла искать дубли по оставшемуся списку имеющихся фруктов
                    break;
                }
            }
            //если же фрукт не встретился
            if (isUnique) {
                //то сохраняем его в дубли для сравнения дальнейшего
                existedFruit = fruitsCopyAndPlusElement(existedFruit);
                existedFruit = addExistedFruitToUnlikeArray(existedFruit,
                        purchases[indexOfPurchases], existedFruit.length - 1);

                //и сохраняем его как уникальный фрукт
                uniqueFruits = fruitsCopyAndPlusElement(uniqueFruits);
                uniqueFruits = addExistedFruitToUnlikeArray(uniqueFruits,
                        purchases[indexOfPurchases], uniqueFruits.length - 1);
            }
        }
        //сохраняем полученные массивы в поля объекта
        unlikedFruits = existedFruit;
        purchases = uniqueFruits;
    }

    /**
     * Добаляет фрукт в массив несвежих.
     * @param fruitsArray массив в который доавбляем эл-т
     * @param fruit       доавбляемый фрукт
     * @param index       индекс в который ложим фрукт
     * @return массив с доавбленным эл-том
     */
    private Fruit[] addExistedFruitToUnlikeArray(Fruit[] fruitsArray, Fruit fruit, int index) {
        fruitsArray[index] = fruit;
        return fruitsArray;
    }

}
