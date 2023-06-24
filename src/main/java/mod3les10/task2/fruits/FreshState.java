package mod3les10.task2.fruits;

//Для фруктов нужно добавить
//        - внутренний параметр freshness - отражает состояние свежести фрукта;
//        для значений нужно завести enum с как минимум состояниями: FRESH, OVERRIPED, SPOILED
//        при создании объект имеет состояние FRESH

import java.io.Serializable;

public enum FreshState {
    FRESH,
    OVERRIPED,
    SPOILED;
}

