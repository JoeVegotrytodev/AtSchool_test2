package mod2les65.com.fruitbase.fruits;

import java.math.BigDecimal;

public class Orange extends Fruit{

    //В конструкторе класса устанавливаются значения веса, цены, названия для фрукта
    public Orange() {
        //нужен ли тут супер? Вроде да. но не уверен
        super();

        weight = 0.5;
        price = new BigDecimal(200);
        name = "Orange";
    }
}
