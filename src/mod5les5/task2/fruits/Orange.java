package mod5les5.task2.fruits;

import mod4les4.task2.fruits.FreshState;
import mod4les4.task2.fruits.Fruit;

import java.io.Serializable;
import java.math.BigDecimal;

public class Orange extends Fruit implements Serializable {

    private static final long serialVersionUID = 1L;

    //В конструкторе класса устанавливаются значения веса, цены, названия для фрукта
    public Orange() {
        //нужен ли тут супер? Вроде да. но не уверен
        super();

        weight = 0.5;
        price = new BigDecimal(200);
        name = "Orange";
        freshness = FreshState.FRESH;
    }
}
