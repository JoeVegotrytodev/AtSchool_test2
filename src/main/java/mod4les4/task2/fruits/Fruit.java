package mod4les4.task2.fruits;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Random;

public abstract class Fruit implements Serializable{

    private static final long serialVersionUID = 1L;
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
//    делал когда еше не было видео лекции, посмотрю, исправлю
//
//    @Override
//    public int hashCode(){
//        final int prime = 9;
//        int result = 1;
//
//        result = result * prime + (name != null ? name.hashCode() : 0);
//        result = result * prime + (freshness != null ? freshness.hashCode() : 0);
//        result = result * prime + (price != null ? price.hashCode() : 0);
//        return result;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if(this == obj)
//            return true;
//        else if(obj == null || getClass() != obj.getClass())
//            return false;
//
//        Fruit objToCompare = (Fruit) obj;
//
//        return this.weight == objToCompare.weight &&
//                Objects.equals(price, objToCompare.price) &&
//                Objects.equals(name, objToCompare.name) &&
//                Objects.equals(freshness, objToCompare.freshness);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return Double.compare(fruit.weight, weight) == 0 && Objects.equals(price, fruit.price) && Objects.equals(name, fruit.name) && freshness == fruit.freshness;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, price, name, freshness);
    }

}
