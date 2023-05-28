package mod7les6.task3;

import java.util.HashMap;
import java.util.Set;

public class Basket<T> {

    private HashMap<String, T> basket = new HashMap<>(5);

    public void addItem(T key){
        basket.put(key.toString(), key);
    }

    public void printBasket(){
        for (String str : basket.keySet()) {
            System.out.println(str + " " +  basket.get(str).getClass().getSimpleName());
        }
    }

    Set<String> getKeys(){
        return basket.keySet();
    }
}
