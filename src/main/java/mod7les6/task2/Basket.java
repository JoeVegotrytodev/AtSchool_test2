package mod7les6.task2;

import java.util.*;

public class Basket<T> {

    private HashMap<T, String> basket = new HashMap<>(5);

    public void addItem(T key){
        basket.put(key, key.getClass().toString());
    }

//    Сперва сделал так, а позже переделал через keySet
//    public void printBasket(){
//        Iterator iterator = basket.entrySet().iterator();
//
//        while(iterator.hasNext()){
//            Map.Entry<T, String> entry = (Map.Entry<T, String>) iterator.next();
//            System.out.println(entry.getKey());
//        }
//
//    }
    public void printBasket(){
        for (T t : basket.keySet()) {
            System.out.println(t);
        }
    }
}
