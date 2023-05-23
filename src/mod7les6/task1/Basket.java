package mod7les6.task1;

import java.util.ArrayList;

public class Basket<T> {
    private ArrayList<T> basket = new ArrayList<>(5);
    public void addItem(T obj){
        basket.add(obj);
    }

    /*
    Не по заданию. Для себя - попробовать сделал
     */
    public void printBasket(){
        for(T obj : basket){
            System.out.println(obj);
        }
    }
}
