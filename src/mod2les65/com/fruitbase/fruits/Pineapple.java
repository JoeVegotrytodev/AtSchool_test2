package mod2les65.com.fruitbase.fruits;

import java.math.BigDecimal;

public class Pineapple extends Fruit{

    //В конструкторе класса устанавливаются значения веса, цены, названия для фрукта
    public Pineapple() {
        //нужен ли тут супер? Вроде да. но не уверен
        super();

        weight = 0.25;
        price = new BigDecimal(140);
        name = "Pineapple";
    }
}
