package mod2les65.com.fruitbase.fruits;

import java.math.BigDecimal;
import java.util.Random;

public abstract class Fruit {
    /*содержит наследуемое поле вес
    содержит наследуемое поле цена
    содержит наследуемое поле name

    Вес измеряется в кг и имеет тип double.
    Цена измеряется в у.е. и имеет тип BigDecimal.
     */
    protected double weight;
    protected BigDecimal price;
    protected String name;
    //- внутренний параметр freshness - отражает состояние свежести фрукта;
    protected FreshState freshness;


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

    //- метод isFresh - возвращает true, если параметр freshness имеет состояние FRESH
    public boolean isFresh(){
        return freshness == FreshState.FRESH;
    }

//    - метод equals
//    - метод hashcode
    @Override
    public int hashCode(){
        price = price.multiply(new BigDecimal(weight));
        int res = price.intValue();

        int maxValue = 8;
        int minValue = 1;
        int range = maxValue - minValue + 1;
        Random random = new Random();
        int numOfSuits = random.nextInt(range) + minValue;

        return res * numOfSuits;
    }

    @Override
    public boolean equals(Object obj) {
        return (this.hashCode() == obj.hashCode());
    }
}
