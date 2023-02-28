package mod2les65.com.fruitbase;
//находится в пакете com.fruitbase

import mod2les65.com.fruitbase.fruits.Fruit;

import java.math.BigDecimal;

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
    public double getWeight(){
        return weightSum;
    }

    //содержит общедоступный метод getPrice - возвращает суммарную цену груза
    public BigDecimal getPrice(){
        return priceSum;
    }

    public void getFruits(){
        for(Fruit fruit : orderedFruit){
            System.out.println(fruit.getName());
        }
    }

    /*
    содержит метод addFruit, доступный только в пакете
    - добавляет Fruit во внутренний массив
     */
    void addFruit(Fruit fruit){
        //создаем больший массив
        //System.out.println(orderedFruit.length);
        Fruit[] plusFruit = new Fruit[10];
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
    public String toString(){
        System.out.println("Order :");

        //for(Fruit fruit : orderedFruit){
        //    System.out.println(fruit.getName());
        //}
        return " weight = " + weightSum + " price = " + priceSum;
    }
}
