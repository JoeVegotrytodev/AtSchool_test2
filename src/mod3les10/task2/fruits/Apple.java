package mod3les10.task2.fruits;

import java.io.Serializable;
import java.math.BigDecimal;

public class Apple extends Fruit implements Serializable{

    private static final long serialVersionUID = 1L;

    //В конструкторе класса устанавливаются значения веса, цены, названия для фрукта
    public Apple() {
        //нужен ли тут супер? Вроде да. но не уверен
        super();

        weight = 0.3;
        price = new BigDecimal(100);
        name = "Apple";
        freshness = FreshState.FRESH;
    }
}
