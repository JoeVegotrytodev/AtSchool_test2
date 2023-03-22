package mod2les65.com.fruitbase.customers;

import mod2les65.com.fruitbase.Cargo;
import mod2les65.com.fruitbase.fruits.Fruit;

import java.util.Arrays;

//Надо создать новый пакет customers и в нем создать новые классы
public abstract class Customer {
    //    имеет внутренний массив покупок фруктов purchases
    protected Fruit[] purchases;
    //    имеет внутреннее поле name - имя покупателя
    protected String name;
    //
    protected Fruit[] unlikedFruits;

    //    имеет конструктор
    public Customer(Fruit[] purchases, String name) {
//      инициализируется внутренний массив
        System.out.println("inside cust const = " +
                Arrays.toString(purchases) + '\n');
        this.purchases = purchases;
//      устанавливается имя
        this.name = name;

        unlikedFruits = new Fruit[0];
    }

    //    имеет метод takeFruits, который должны реализовать наследникик
//    метод принимает груз и сохраняет из него фрукты во внутренний массив,
//    т.е. в грузе объекты заканчиваются.
    public abstract void takeFruits();

    //    имеет метод printPurchases,  метод выводит полученные фрукты
    public void printPurchases() {
        System.out.println("inside print purchases = " +
                Arrays.toString(purchases) + '\n');
        System.out.print("Фрукты " + name + " : ");
        for (Fruit f : purchases) {
            if (f != null) {
                System.out.print(f.getName() + " ");
            }
        }
        System.out.print('\n');
    }

    public Fruit[] getPurchases() {
        return purchases;
    }

    public void printUnlikedFruits() {
        System.out.print("Неподошедшие фрукты : ");


        for (Fruit f : unlikedFruits) {
            if(f != null)
                System.out.print(f.getName() + " ");
        }
        System.out.print('\n');

    }
}
