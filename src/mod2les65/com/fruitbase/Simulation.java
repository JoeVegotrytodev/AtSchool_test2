package mod2les65.com.fruitbase;

import mod2les65.com.fruitbase.customers.Customer;
import mod2les65.com.fruitbase.customers.FreshCustomer;
import mod2les65.com.fruitbase.customers.UniqueCustomer;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Simulation {
//    Также добавим специальный класс Simulation, внутри которого
//    теперь будет выполняться программа.

    //    Для этого в него перенесем метод main из Fruitbase и внесем изменения:
    public static void main(String[] args) {
        //Если передан "пустой запрос" (не переданы аргументы), то программа завершается.
        if(args.length == 0){
            System.out.println("args is empty");
            return;
        }

        //создается фруктовая база
        FruitBase base = new FruitBase();
        //    - после создания объекта FruitBase создается массив покупателей,
        //    в который будут входит экземпляры обоих видов покупателей
        //- далее для каждого покупателя:
        //    выполняется заказ и формируется груз
        Customer[] customers = new Customer[2];
        Cargo c = base.takeOrder(args);

        customers[0] = new FreshCustomer(c.getFruits(),"Свежий клиент");
        customers[1] = new UniqueCustomer(c.getFruits(),"Уникальный клиент");

        //- далее для каждого покупателя:
        for(Customer customer : customers){
            //    выводится информации о грузе
            customer.printPurchases();
            //    покупатель выбирает из груза интересующие его фрукты
            customer.takeFruits();
            //    покупатель выводит полученные фрукты
            customer.printPurchases();
            //    выводится информации об оставшемся грузе
            customer.printUnlikedFruits();
            System.out.print("\n");
        }
    }
}
