package mod2les65.com.fruitbase.customers;

import mod2les65.com.fruitbase.fruits.Fruit;

import java.util.Arrays;

public class UniqueCustomer extends Customer {

    public UniqueCustomer(Fruit[] fruits, String name) {
        super(fruits, name);
        this.purchases = fruits;
        this.name = name;
    }

//    реалиация метода takeFruits отбирает только уникальные фрукты,
//    т.е. те, которых еще нет во внутреннем массиве
    public void takesFruits() {
        //создаем массив уникальных фруктов хранящий уникальные фрукты
        Fruit[] uniqueFruits = new Fruit[1];

        //укажем первый эл-т массива, чтобы было с чем сравнивать
        //первый эл-т  не может быть дублирующим
        uniqueFruits[0] = purchases[0];

        //хранит номер эл-та массива уникальных фруктов
        int uniqueFruitIndex = 1;

        boolean isUnique = true;

        for (int i = 1; i < purchases.length; i++) {
            System.out.println("\nБерем из общего : " + getPurchases()[i].getName());
            for (int j = 0; j < uniqueFruitIndex; j++) {
                if (purchases[j] == null)
                    break;

                System.out.println("Сравниваем с : " + uniqueFruits[j].getName());

                if (getPurchases()[i].getName().equals(uniqueFruits[j].getName())) {
                    System.out.println("Совпали : " + getPurchases()[i].getName() +
                            " " + uniqueFruits[j].getName());

                    isUnique = false;
                    break;
                }
                uniqueFruits = fruitsCopyAndPlusElement(uniqueFruits);
                uniqueFruits = addUnfreshFruitToUnlikeArray(uniqueFruits,
                        purchases[i], uniqueFruits.length - 1);
                uniqueFruitIndex++;
            }
            if (!isUnique) {
//                uniqueFruits = fruitsCopyAndPlusElement(uniqueFruits);
//                uniqueFruits = addUnfreshFruitToUnlikeArray(uniqueFruits,
//                        purchases[i], uniqueFruits.length - 1);
//                uniqueFruitIndex++;
//            } else {
                unlikedFruits = fruitsCopyAndPlusElement(unlikedFruits);
                unlikedFruits = addUnfreshFruitToUnlikeArray(unlikedFruits,
                        purchases[i], unlikedFruits.length - 1);
            }
        }
        purchases = uniqueFruits;
    }

    public void takeFruits() {
        Fruit[] existedFruit = new Fruit[1];
        Fruit[] uniqueFruits = new Fruit[0];

        for (int indexOfPurchases = 0; indexOfPurchases < purchases.length; indexOfPurchases++) {
            boolean isUnique = true;
            for (int indexOfExist = 0; indexOfExist < existedFruit.length; indexOfExist++) {

                if(indexOfPurchases == 0){
                    existedFruit[0] = purchases[0];
                    System.out.println("Array in iskl " + Arrays.toString(existedFruit));
                    break;
                }
                System.out.println("indexOfPurchases " + indexOfPurchases + ". purchase " + purchases[indexOfPurchases].getName());
                System.out.println("indexOfExist " + indexOfExist + ". exist " + existedFruit[indexOfExist].getName());

                if (purchases[indexOfPurchases].getName().equals(existedFruit[indexOfExist].getName())) {

                    System.out.println("match___");
                    if(indexOfPurchases == 1 && existedFruit[0].getName().equals(purchases[1].getName())){
                        System.out.println("Array in iskl " + Arrays.toString(existedFruit));
                        System.out.println("iskluchenie");
                        isUnique = false;
                        continue;
                    }

                    System.out.println(existedFruit.length);

                    System.out.println("Array before " + Arrays.toString(existedFruit));
                    existedFruit = fruitsCopyAndPlusElement(existedFruit);
                    existedFruit = addUnfreshFruitToUnlikeArray(existedFruit,
                            purchases[indexOfPurchases], existedFruit.length - 1);

                    isUnique = false;

                    System.out.println(existedFruit.length);
                    System.out.println("Array after " + Arrays.toString(existedFruit));
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

}
