package mod2les65.com.fruitbase.customers;

import mod2les65.com.fruitbase.fruits.Fruit;

//Надо создать новый пакет customers и в нем создать новые классы
public abstract class Customer {
    //    имеет внутренний массив покупок фруктов purchases
    protected Fruit[] purchases;
    //    имеет внутреннее поле name - имя покупателя
    protected String name;
    //    массив неподошедших фруктов
    protected Fruit[] unlikedFruits;

    //    имеет конструктор
    public Customer(Fruit[] purchases, String name) {
//      инициализируется внутренний массив
        this.purchases = purchases;
//      устанавливается имя
        this.name = name;
        //иниициализируем массив
        unlikedFruits = new Fruit[0];
    }

//    имеет метод takeFruits, который должны реализовать наследникик
//    метод принимает груз и сохраняет из него фрукты во внутренний массив,
//    т.е. в грузе объекты заканчиваются.
    public abstract void takeFruits();


    //    имеет метод printPurchases,  метод выводит полученные фрукты
    public void printPurchases() {
        System.out.print("Фрукты, " + name + ": ");

        for (Fruit f : purchases) {
            if (f != null) {
                System.out.print(f.getName() + " ");
            }
        }
        System.out.print('\n');
    }

    /**
     * getter for purchases
     *
     * @return array of fruits
     */
    public Fruit[] getPurchases() {
        return purchases;
    }

    /**
     * метод выводит неподошедшие покупателю фрукты
     */
    public void printUnlikedFruits() {
        System.out.print("Неподошедшие фрукты, " + name + ": ");

        for (Fruit f : unlikedFruits) {
            if (f != null)
                System.out.print(f.getName() + " ");
        }
        System.out.print('\n');
    }

    /**
     * Копирует массив и добавялет + 1 пустой эл-т
     * @param arrayToCopy массив который необхоидмо скопировать
     * @return скопированный массив с последним пустым эл-том
     */
    protected Fruit[] fruitsCopyAndPlusElement(Fruit[] arrayToCopy) {
        Fruit[] arrayAfterCopying = new Fruit[arrayToCopy.length + 1];
        int counter = 0;

        //сделал проверку, чтобы к  0 эл-ту не обращаться
//        if (arrayToCopy.length > 0) {
        for (Fruit frt : arrayToCopy) {
            //если это нулл эл-т то прерываем
            //не совсем понял этот момент правильно ли вообще так проверять
            if (frt == null) {
                break;
            }
            arrayAfterCopying[counter] = frt;
            counter++;
        }
//        }
        return arrayAfterCopying;
    }
}
