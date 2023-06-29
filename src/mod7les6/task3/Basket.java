package mod7les6.task3;

import java.util.HashMap;
import java.util.Set;

public class Basket<T> {

    private HashMap<String, T> basket = new HashMap<>(5);

//    public void addItem(T key){
//        basket.put(key.toString(), key);
//    }

    public void printBasket(){
        Set<String> myIterable = basket.keySet();

        myIterable.forEach((key) -> System.out.println(key + " " + basket.get(key).getClass().getSimpleName()));
    }

    public HashMap<String, T> getBasket(){
        return  basket;
    }
}
