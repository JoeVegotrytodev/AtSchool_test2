package mod2les65.com.fruitbase.fruits;

import java.math.BigDecimal;

public class Banana extends Fruit{

    //В конструкторе класса устанавливаются значения веса, цены, названия для фрукта
    public Banana() {
        //нужен ли тут супер? Вроде да. но не уверен
        super();

        weight = 0.2;
        price = new BigDecimal(150);
        name = "Banana";
        freshness = FreshState.FRESH;
    }
}
