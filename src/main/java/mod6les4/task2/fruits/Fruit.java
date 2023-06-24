package mod6les4.task2.fruits;

import mod6les4.task2.fruits.FreshState;

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

    //- если в проекте отсутствует, добавьте в класс Fruit конструктор cо всеми обязательными полями в качестве аргументов.
    public Fruit(double weight, BigDecimal price, String name, FreshState freshness) {
        this.weight = weight;
        this.price = price;
        this.name = name;
        this.freshness = freshness;
    }

    public Fruit(){}

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
