package mod5les5.task2;

import mod4les4.task2.customers.Customer;
import mod4les4.task2.customers.FreshCustomer;
import mod4les4.task2.customers.UniqueCustomer;

import java.io.FileNotFoundException;
import java.io.IOException;

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
        } else if (fruitBase.getFlag(args).startsWith("-e=")) {
            try {
                String path = fruitBase.getFlag(args).substring(3);
                fruitBase.exportCatalogue(path);
                fruitBase.print();
            } catch (FileNotFoundException fnfExc) {
                System.out.println("Не найден файл ");
            } catch (IOException ioExc) {
                System.out.println("Ошибка при экспорте каталога в ");
            } catch (Exception exc) {
                System.out.println("Непредведенная ошибка при экспорте каталога из файла ");
            }
        } else if (fruitBase.getFlag(args).startsWith("-i=")) {
            try {
                String path = fruitBase.getFlag(args).substring(3);
                fruitBase.importCatalogue(path);
                fruitBase.print();
            } catch (FileNotFoundException fnfExc) {
                System.out.println("Не найден файл ");
            } catch (IOException ioExc) {
                System.out.println("Ошибка при импорте каталога в ");
            } catch (ClassNotFoundException classExc) {
                System.out.println("Невозможно импортировать каталог из файла : неподдерживаемая версия");
            } catch (Exception exc) {
                System.out.println("Непредведенная ошибка при экспорте каталога из файла ");
            }
        } else {
            //- далее для каждого покупателя:
            //    выполняется заказ и формируется груз
            Cargo freshCustomerOrder = new Cargo(delivery);
            Cargo uniqueCustomerOrder = new Cargo(delivery);

            customers[0] = new FreshCustomer(freshCustomerOrder.getFruits(), "Свежий клиент");
            customers[1] = new UniqueCustomer(uniqueCustomerOrder.getFruits(), "Уникальный клиент");

            //- далее для каждого покупателя:
            for (Customer customer : customers) {
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
}
