package mod2les65.com.fruitbase;

import mod2les65.com.fruitbase.customers.Customer;
import mod2les65.com.fruitbase.customers.FreshCustomer;
import mod2les65.com.fruitbase.customers.UniqueCustomer;

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
        Cargo c = null;

//        for(int i = 0; i < args.length; i++){
//            System.out.println("console " + args[i]);
//            c = base.takeOrder(args[i]);
//        }
        c = base.takeOrder(args);

        customers[0] = new FreshCustomer(c.getFruits(),"Petr");
        customers[1] = new UniqueCustomer(c.getFruits(),"Pavel");

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


//        for(int i = 0; i < args.length; i++){
//            base.takeOrder(args[i]);
//            if(i == args.length - 1)
//                System.out.println(base.takeOrder(args[i]) + "\n");
//        }

    }


}
