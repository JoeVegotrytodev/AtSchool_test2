package mod2les65.com.fruitbase.fruits;

import java.math.BigDecimal;

public class Apple extends Fruit{

    //В конструкторе класса устанавливаются значения веса, цены, названия для фрукта
    public Apple() {
        //нужен ли тут супер? Вроде да. но не уверен
        super();

        weight = 0.3;
        price = new BigDecimal(100);
        name = "Apple";
    }
}
