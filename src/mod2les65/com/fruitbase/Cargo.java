package mod2les65.com.fruitbase;
//находится в пакете com.fruitbase

import mod2les65.com.fruitbase.fruits.Fruit;

import java.math.BigDecimal;
import java.util.Arrays;

public class Cargo {
    //содержит поле массив Fruit - записи о фруктах, добавленных в груз
    private Fruit[] orderedFruit;
    private double weightSum = 0;
    private BigDecimal priceSum = new BigDecimal(0);
    int putLoc = 0;

    /*
    содержит консткрутор без параметров
    в нем инициализируется внутренний массив
     */
    public Cargo() {
        orderedFruit = new Fruit[0];
    }

    //содержит общедоступный метод getWeight - возвращает суммарный вес груза
    public double getWeight() {
        return weightSum;
    }

    //содержит общедоступный метод getPrice - возвращает суммарную цену груза
    public BigDecimal getPrice() {
        return priceSum;
    }

    //метод из старого задания. Не использваолся в программе. Заменил
//    public void getFruits(){
//        for(Fruit fruit : orderedFruit){
//            System.out.println(fruit.getName());
//        }
//    }
//    В класс Cargo надо добавить
//    - общедоступный метод getFruits
//    с его помощью покупатели получают фрукты из груза
//    возвращает список фруктов
    //уже спел реализовать этот метод самостоятельно)
    public Fruit[] getFruits() {
        System.out.println("inside cargo = " +
                Arrays.toString(orderedFruit) + '\n');
        return orderedFruit;
    }

    /*
    содержит метод addFruit, доступный только в пакете
    - добавляет Fruit во внутренний массив
     */
    void addFruit(Fruit fruit) {
        //создаем больший массив
        System.out.println(orderedFruit.length);
        //еще тут было, поправил
        //Fruit[] plusFruit = new Fruit[10];
        Fruit[] plusFruit = new Fruit[orderedFruit.length + 1];
        for(Fruit f : orderedFruit){
            for(int i = 0 ; i < plusFruit.length - 1; i++){
                plusFruit[i] = f;
            }
        }
        //добавляем в него  фрукт
        plusFruit[putLoc] = fruit;
        putLoc++;
        //System.out.println(orderedFruit.length - 1);
        //перезаписываем массив класса Cargo
        orderedFruit = plusFruit.clone();

        //изменияем сумму и вес
        weightSum = weightSum + fruit.getWeight();
        priceSum = priceSum.add(fruit.getPrice());
    }

    @Override
    public String toString() {
        System.out.println("Order :");

//        for(Fruit fruit : orderedFruit){
//            System.out.println(fruit.getName());
//        }
        return " weight = " + weightSum + " price = " + priceSum;
    }

    //    - общедоступный метод removeFruit
//    получает в качестве параметра фрукт
//    если такого фрукта нет во внутреннем списке, то метод завершается
//    иначе убирает фрукт с указанным названием из внутреннего массива и возвращает его
    public Fruit[] removeFruit(Fruit fruit) {
        Fruit[] uniqueFruits = new Fruit[orderedFruit.length - 1];
        int index = 0;
        //можно ли так делать или есть лучше способы иначе переменная не инициализирована
        Fruit notUniqueFruit = null;

        boolean isUnique = true;
        for(Fruit f : orderedFruit) {
            if (f.getName().equals(fruit.getName())) {
                isUnique = false;
                notUniqueFruit = f;
                break;
            }
        }

        //Можно ли не возврашать нулл
        if(isUnique) return null;
        else{
            for(Fruit f : orderedFruit){
                if(f.getName().equals(notUniqueFruit.getName()))
                    continue;
                else{
                    uniqueFruits[index] = f;
                    index++;
                }
            }
            orderedFruit = uniqueFruits;
            return orderedFruit;
        }
    }
}
