package mod7les6.task1;

import java.lang.reflect.Array;

public class Basket<T> {

    private T[] basket;
    Class aClass;
    Basket(Class <T> clas){
        basket = (T[]) Array.newInstance(clas, 0);
        aClass =  clas;
    }

    public void addItem(T obj){
        T[] tempBasket ;
        tempBasket = (T[]) Array.newInstance(aClass, basket.length + 1);
        for(int i = 0; i < basket.length; i++){
            tempBasket[i] = basket[i];
        }
        basket = tempBasket.clone();
        basket[basket.length - 1] = obj;
    }

    /*
    Не по заданию. Для себя сделал
     */
    public void printBasket(){
        for(T obj : basket){
            System.out.println(obj.getClass().getSimpleName());
        }
    }
}
