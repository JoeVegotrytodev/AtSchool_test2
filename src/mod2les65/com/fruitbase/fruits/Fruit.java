package mod2les65.com.fruitbase.fruits;

import java.math.BigDecimal;

public abstract class Fruit {
    /*содержит наследуемое поле вес
    содержит наследуемое поле цена
    содержит наследуемое поле name

    Вес измеряется в кг и имеет тип double.
    Цена измеряется в у.е. и имеет тип BigDecimal.
     */
    double weight;
    BigDecimal price;
    String name;

    //содержит общедоступный метод по-умолчанию для получения значения веса getWeight
    public double getWeight(){
        return weight;
    }

    //содержит общедоступный метод по-умолчанию для получения значения цены getPrice
    public BigDecimal getPrice(){
        return price;
    }

    //содержит общедоступный метод по-умолчанию для получения значения цены getName
    public String getName(){
        return name;
    }
}
