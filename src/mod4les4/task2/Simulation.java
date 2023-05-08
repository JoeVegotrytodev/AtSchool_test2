package mod4les4.task2;

import mod4les4.task2.customers.Customer;
import mod4les4.task2.customers.FreshCustomer;
import mod4les4.task2.customers.UniqueCustomer;

import java.io.Serializable;

public class Simulation {
//    Также добавим специальный класс Simulation, внутри которого
//    теперь будет выполняться программа.

    //    Для этого в него перенесем метод main из Fruitbase и внесем изменения:
    public static void main(String[] args) {

        System.out.println("\n" + "-- методы, которые сам создал, Java доком описал --\n" +
                "-- для демонстрации сделал Ананас не свежим фруктом --\n");

        //Если передан "пустой запрос" (не переданы аргументы), то программа завершается.
        if (args.length == 0) {
            System.out.println("args is empty");
            return;
        }

        //создается фруктовая база
        // - после создания объекта FruitBase создается массив покупателей,
        //    в который будут входит экземпляры обоих видов покупателей
        Customer[] customers = new Customer[2];
        //используя ранее написанные методы длф ормирования груза, эта строка для чтения консоли была и
        //возаращала объект класса груз
        FruitBase fruitBase = new FruitBase();
        Delivery delivery = fruitBase.takeOrder(args);

        if (fruitBase.getFlag(args).equals("-e") | fruitBase.getFlag(args).equals("--export")) {
            fruitBase.exportCatalogue();
            fruitBase.print();
        } else if (fruitBase.getFlag(args).equals("-i") | fruitBase.getFlag(args).equals("--import")) {
            fruitBase.importCatalogue();
            fruitBase.print();
            System.out.println();
        }
        else {
            //- далее для каждого покупателя:
            //    выполняется заказ и формируется груз
            Cargo freshCustomerOrder = new Cargo(delivery);
            Cargo uniqueCustomerOrder = new Cargo(delivery);

//            customers[0] = new FreshCustomer(freshCustomerOrder.getFruits(), "Свежий клиент");
//            customers[1] = new UniqueCustomer(uniqueCustomerOrder.getFruits(), "Уникальный клиент");
            Customer freshCustomer = new FreshCustomer(freshCustomerOrder.getFruits(), "Свежий клиент");
            Customer uniqueCustomers = new UniqueCustomer(uniqueCustomerOrder.getFruits(), "Уникальный клиент");

            //    выводится информации о грузе
            freshCustomer.printPurchases();
            //    покупатель выбирает из груза интересующие его фрукты
            freshCustomer.takeFruits(freshCustomerOrder);
            //    покупатель выводит полученные фрукты
            freshCustomer.printPurchases();
            //    выводится информации об оставшемся грузе
            //совершенно забыл про метод ремув класса Карго и создал отедльный массив фруктов покупателю
            // и метод для его вывода вместо того чтобы работать с заказом класса Карго
            freshCustomer.printUnlikedFruits();
            System.out.print("\n");

            uniqueCustomers.printPurchases();
            uniqueCustomers.takeFruits(uniqueCustomerOrder);
            uniqueCustomers.printPurchases();
            uniqueCustomers.printUnlikedFruits();
        }
    }
}
