package mod7les6.task3;

import java.util.HashMap;

public class Basket<T> {

//    private HashMap<T, String> basket = new HashMap<>(5);
    private HashMap<String, T> basket = new HashMap<>(5);

    public void addItem(T key){
        basket.put(key.toString(), key);
    }

    public void printBasket(){
        for (String str : basket.keySet()) {
            System.out.println(str + " " + str.getClass());
        }
    }
}
