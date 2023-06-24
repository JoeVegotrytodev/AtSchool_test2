package mod6les4.task2;

import mod6les4.task2.fruits.*;
import java.io.Serializable;
import java.math.BigDecimal;

public class FruitCatalogue implements Serializable{
    //содержит поле массив Fruit - список записей известных фруктов
    private Fruit[] fruitList;
    private static final long serialVersionUID = 1L;


    Fruit Kiwi = new Fruit(0.35, BigDecimal.valueOf(380), "Kiwi", FreshState.SPOILED){};

    Fruit Mango = new Fruit(0.75, BigDecimal.valueOf(400), "Mango", FreshState.SPOILED){};

    /*содержит конструктор без параметров
        при создании во внутренний массив добавляются
        записи-экзмепляры известных фруктов
     */
    public FruitCatalogue() {
        fruitList = new Fruit[]{new Apple(), new Banana(), new Orange(), new Pineapple()
        , Kiwi, Mango};
    }

    /*
    содержит метод findFruit, доступный только в пакете
        по переданному слову проверяет есть ли информация о таком фрукте
        если есть, то возвращает Fruit. Если нет, то возвращает null
     */
    Fruit findFruit(String fruitName){
        for(Fruit fruit : fruitList){
            if(fruit.getName().equals(fruitName)) {
                return fruit;
            }
        }
        return null;
    }

    public void print(){
        for(Fruit fruit : fruitList){
            System.out.println(fruit.getName() + " " + fruit.getPrice() + " " + fruit.getWeight());
        }
    }

    /* - в класс FruitCatalogue, используя анонимные классы, во внутренний каталог добавьте фрукты:
    * Mango
    * Kiwi
     */
//    class Kiwi extends Fruit{
//        public Kiwi() {
//            weight = 0.35;
//            price = new BigDecimal(400);
//            name = "Kiwi";
//            freshness = FreshState.SPOILED;
//        }
//    }
//
//    class Mango extends Fruit{
//        public Mango() {
//            weight = 0.75;
//            price = new BigDecimal(600);
//            name = "Mango";
//            freshness = FreshState.OVERRIPED;
//        }
//    }

}
