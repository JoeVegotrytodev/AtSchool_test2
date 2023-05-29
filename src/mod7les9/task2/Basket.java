package mod7les9.task2;

import java.util.HashMap;

public class Basket<T> {

    private HashMap<String, T> basket = new HashMap<>(5);

    public void printBasket(){
        for (String str : basket.keySet()) {
            System.out.println(str + " " +  basket.get(str).getClass().getSimpleName());
        }
    }

    public HashMap<String, T> getBasket(){
        return  basket;
    }

    public int getSize(){
        return basket.size();
    }
}
