package mod2les65.com.fruitbase;

import mod2les65.com.fruitbase.customers.Customer;
import mod2les65.com.fruitbase.customers.FreshCustomer;
import mod2les65.com.fruitbase.customers.UniqueCustomer;

public class Simulation {
//    Также добавим специальный класс Simulation, внутри которого
//    теперь будет выполняться программа.

    //    Для этого в него перенесем метод main из Fruitbase и внесем изменения:
    public static void main(String[] args) {

        System.out.println("\n" + "-- методы, которые сам создал, Java доком описал --\n" +
                "-- для демонстрации сделал Ананас не свежим фруктом --\n");

        //Если передан "пустой запрос" (не переданы аргументы), то программа завершается.
        if(args.length == 0){
            System.out.println("args is empty");
            return;
        }

        //создается фруктовая база
        // - после создания объекта FruitBase создается массив покупателей,
        //    в который будут входит экземпляры обоих видов покупателей
        Customer[] customers = new Customer[2];
        //используя ранее написанные методы длф ормирования груза, эта строка для чтения консоли была и
        //возаращала объект класса груз
        Cargo cargo = new FruitBase().takeOrder(args);
        //- далее для каждого покупателя:
        //    выполняется заказ и формируется груз
        Cargo freshCustomerOrder = new Cargo(cargo);
        Cargo uniqueCustomerOrder = new Cargo(cargo);

        customers[0] = new FreshCustomer(freshCustomerOrder.getFruits(),"Свежий клиент");
        customers[1] = new UniqueCustomer(uniqueCustomerOrder.getFruits(),"Уникальный клиент");

        //- далее для каждого покупателя:
        for(Customer customer : customers){
            //    выводится информации о грузе
            customer.printPurchases();
            //    покупатель выбирает из груза интересующие его фрукты
            customer.takeFruits();
            //    покупатель выводит полученные фрукты
            customer.printPurchases();
            //    выводится информации об оставшемся грузе
            //совершенно забыл про метод ремув класса Карго и создал отедльный массив фруктов покупателю
            // и метод для его вывода вместо того чтобы работать с заказом класса Карго
            customer.printUnlikedFruits();
            //сделаю костыль
            System.out.print("\n");
        }
    }
}
