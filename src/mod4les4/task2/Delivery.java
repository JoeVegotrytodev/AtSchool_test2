package mod4les4.task2;

import java.math.BigDecimal;
import mod4les4.task2.fruits.Fruit;

/*В проект фруктовой базы, в пакет fruitbase, добавьте интерфейс Delivery.
Содержит следующие абстрактные методы
   double getWeight();
   BigDecimal getPrice();
   void addFruit(Fruit fruit);
   Fruit[] getFruits();
   void removeFruit(Fruit fruit);
 */
public interface Delivery {
    double getWeight();
    BigDecimal getPrice();
    void addFruit(Fruit fruit);
    Fruit[] getFruits();
    Fruit[] removeFruit(Fruit fruit);
}
