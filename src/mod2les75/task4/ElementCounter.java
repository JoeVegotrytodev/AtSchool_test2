package mod2les75.task4;

import java.util.Objects;

public class ElementCounter {
//    - внутреннее строковое поле value
    private String value;
//    - внутреннее поле count (счетчик)
    private int counter;
//    - конструктор, который на вход принимает строковое значение value присваивается полученное значение counter становится 1
    public ElementCounter(String value) {
        this.value = value;
        counter = 1;
    }
//     - геттеры для строкового поля и счетчика
    public String getValue() {
        return value;
    }

    public int getCounter() {
        return counter;
    }

//    - метод inc - увеличивает счетчик на один
    public void inc(){
        counter++;
    }
//    - метод equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElementCounter that = (ElementCounter) o;
        return counter == that.counter && Objects.equals(value, that.value);
    }
    //    - метод hashCode
    @Override
    public int hashCode() {
        return Objects.hash(value, counter);
    }

    @Override
    public String toString() {
        return value;
    }
}
