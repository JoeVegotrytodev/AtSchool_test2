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
        Fruit[] existedFruit = new Fruit[1];
        Fruit[] uniqueFruits = new Fruit[0];

        for (int indexOfPurchases = 0; indexOfPurchases < purchases.length; indexOfPurchases++) {
            boolean isUnique = true;
            for (int indexOfExist = 0; indexOfExist < existedFruit.length; indexOfExist++) {

                if(indexOfPurchases == 0){
                    existedFruit[0] = purchases[0];
//                    System.out.println("Array in iskl " + Arrays.toString(existedFruit));
                    break;
                }
//                System.out.println("indexOfPurchases " + indexOfPurchases + ". purchase " + purchases[indexOfPurchases].getName());
//                System.out.println("indexOfExist " + indexOfExist + ". exist " + existedFruit[indexOfExist].getName());

                if (purchases[indexOfPurchases].getName().equals(existedFruit[indexOfExist].getName())) {

//                    System.out.println("match___");
                    if(indexOfPurchases == 1 && existedFruit[0].getName().equals(purchases[1].getName())){
//                        System.out.println("Array in iskl " + Arrays.toString(existedFruit));
//                        System.out.println("iskluchenie");
                        isUnique = false;
                        continue;
                    }

                    System.out.println(existedFruit.length);

//                    System.out.println("Array before " + Arrays.toString(existedFruit));
                    existedFruit = fruitsCopyAndPlusElement(existedFruit);
                    existedFruit = addUnfreshFruitToUnlikeArray(existedFruit,
                            purchases[indexOfPurchases], existedFruit.length - 1);

                    isUnique = false;

//                    System.out.println(existedFruit.length);
//                    System.out.println("Array after " + Arrays.toString(existedFruit));
                    break;
                }
            }
            if (isUnique) {

                existedFruit = fruitsCopyAndPlusElement(existedFruit);
                existedFruit = addUnfreshFruitToUnlikeArray(existedFruit,
                        purchases[indexOfPurchases], existedFruit.length - 1);

                uniqueFruits = fruitsCopyAndPlusElement(uniqueFruits);
                uniqueFruits = addUnfreshFruitToUnlikeArray(uniqueFruits,
                        purchases[indexOfPurchases], uniqueFruits.length - 1);
            }
        }
        unlikedFruits = existedFruit;
        purchases = uniqueFruits;
    }

//    /**
//     * Копирует массив и добавялет + 1 пустой эл-т
//     * @param arrayToCopy массив который необхоидмо скопировать
//     * @return скопированный массив с последним пустым эл-том
//     */
//    protected Fruit[] fruitsCopyAndPlusElement(Fruit[] arrayToCopy) {
//        Fruit[] arrayAfterCopying = new Fruit[arrayToCopy.length + 1];
//        int counter = 0;
//
//        //сделал проверку, чтобы к  0 эл-ту не обращаться
////        if (arrayToCopy.length > 0) {
//        for (Fruit frt : arrayToCopy) {
//            //если это нулл эл-т то прерываем
//            //не совсем понял этот момент правильно ли вообще так проверять
//            if (frt == null) {
//                break;
//            }
//            arrayAfterCopying[counter] = frt;
//            counter++;
//        }
////        }
//        return arrayAfterCopying;
//    }

    /**
     * Добаляет фрукт в массив несвежих.
     * @param fruitsArray массив в который доавбляем эл-т
     * @param fruit       доавбляемый фрукт
     * @param index       индекс в который ложим фрукт
     * @return массив с доавбленным эл-том
     */
    protected Fruit[] addUnfreshFruitToUnlikeArray(Fruit[] fruitsArray, Fruit fruit, int index) {
        fruitsArray[index] = fruit;
        return fruitsArray;
    }
}
