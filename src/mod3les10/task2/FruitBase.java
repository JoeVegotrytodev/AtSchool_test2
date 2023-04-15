//находится в пакете com.fruitbase
package mod3les10.task2;

import mod3les10.task2.fruits.Fruit;

import java.io.*;
import java.util.Arrays;

public class FruitBase{
    //содержит поле FruitCatalogue
    private FruitCatalogue catalogue;
    Cargo cargo;
    private String flag;

    /*
    содержит конструктор без параметров
    в нем инициализируется поле FruitCatalogue
     */
    public FruitBase() {
        catalogue = new FruitCatalogue();
        cargo = new Cargo();
    }

    /*
    содержит общедоступный метод для обработки заказа takeOrder
        в этом методе происходит поиск слов из заказа в FruitCatalogue
        если хотя бы одно название найдено,
        то формируется груз Cargo с информацией о найденных фруктах
     */
    public Cargo takeOrder(String orderedFruit) {

        if (catalogue.findFruit(orderedFruit) != null) {
            //формируется груз Cargo с информацией о найденных фруктах
            cargo.addFruit(catalogue.findFruit(orderedFruit));
            return cargo;
        }
        // Если среди запроса не встретились известные названия,
        // то возвращается груз Cargo с нулевым количеством фруктов
        else
            return null;
    }

    //перегрузка метода тейк оредер, для приема массива
//    public Cargo takeOrder(String[] orderedFruit) {
//
//        for (String fruitName : orderedFruit) {
//            if (catalogue.findFruit(fruitName) != null) {
//                //формируется груз Cargo с информацией о найденных фруктах
//                cargo.addFruit(catalogue.findFruit(fruitName));
//            }
//        }
//
//        return cargo;
//    }

    public Cargo takeOrder(String[] orderedFruit) {

        for (int index = 0; index < orderedFruit.length; index++) {
            if (catalogue.findFruit(orderedFruit[index]) != null) {
                //формируется груз Cargo с информацией о найденных фруктах
                cargo.addFruit(catalogue.findFruit(orderedFruit[index]));
            }
        }

        flag = orderedFruit[orderedFruit.length - 1];

        return cargo;
    }


    @Deprecated
    public static void main(String[] args) {
        //создается фруктовая база
        FruitBase base = new FruitBase();

        /*
        Если передан "пустой запрос" (не переданы аргументы), то программа завершается.
         */
        if (args.length == 0) {
            System.out.println("args is empty");
            return;
        }


        for (int i = 0; i < args.length; i++) {
            base.takeOrder(args[i]);
            if (i == args.length - 1)
                System.out.println(base.takeOrder(args[i]) + "\n");
        }

    }

    //    Добавьте в класс FruitBase следующие методы:
//            - общедоступный метод exportCatalogue
//    Сериализует внутренний объект FruitCatalogue в проект.
//    Выводится сообщение "каталог экспортирован"
    public void exportCatalogue() {

        try (FileOutputStream fileOutputStream = new FileOutputStream
                ("src/mod3les10/task2/resources/save.ser")) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(catalogue);
//            objectOutputStream.close();
        } catch (IOException exc) {
            exc.printStackTrace();
            System.out.println("Ошибка ввода-вывода");
        }

        System.out.println("Каталог экспортирован");
    }
//    - общедоступный метод importCatalogue
//    Десериализует из проекта объект FruitCatalogue и результатом заменяет текущий внутренний объект.
//    Выводится сообщение "каталог импортирован"
    public void importCatalogue() {
        try (FileInputStream fileInputStream = new FileInputStream
                ("src/mod3les10/task2/resources/save.ser")) {

            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            catalogue = (FruitCatalogue) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException exc) {
            exc.printStackTrace();
            System.out.println("Ошибка ввода-вывода в импорте");
        }

    }

    public String getFlag(){
        return flag;
    }

    public void print(){
        catalogue.print();
    }
}
