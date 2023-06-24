package mod2les65.com.fruitbase;
//находится в пакете com.fruitbase

import mod2les65.com.fruitbase.fruits.*;

public class FruitCatalogue {
    //содержит поле массив Fruit - список записей известных фруктов
    private Fruit[] fruitList;

    /*содержит конструктор без параметров
        при создании во внутренний массив добавляются
        записи-экзмепляры известных фруктов
     */
    public FruitCatalogue() {
        fruitList = new Fruit[]{new Apple(), new Banana(), new Orange(), new Pineapple()};
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

}
