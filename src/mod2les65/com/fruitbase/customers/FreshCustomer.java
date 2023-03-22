package mod2les65.com.fruitbase.customers;

import mod2les65.com.fruitbase.Cargo;
import mod2les65.com.fruitbase.fruits.Fruit;

public class FreshCustomer extends Customer{
//    Для этого класса мы создадим две реализации:
//            - FreshCustomer
//    реалиация метода takeFruits
//    выбираются только свежие фрукты
    public void takeFruits(){
        Fruit[] freshFruits = new Fruit[getPurchases().length];
        int index = 0;
        int jIndex = 0;

        for(Fruit f : getPurchases()){
            if(f == null)
                break;

            if(f.isFresh()){
                freshFruits[index] = f;
                index++;
            }
            else{
                System.out.println("Сюда то хоть попадаем ?");
//                    созадем больший массива
                Fruit[] tempArray = new Fruit[unlikedFruits.length + 1];
                //копируем туда эл-ты
                int lInedx = 0;
                if (unlikedFruits.length > 0) {
                    for(Fruit frt : unlikedFruits){
                        //если это нулл эл-т то прерываем
                        if(frt == null){
                            System.out.println("не сюда бл !!!");
                            break;
                        }

                        System.out.println("дошло !!!");
                        tempArray[lInedx] = frt;
                        lInedx++;
                    }
                }
                else{
                    tempArray[lInedx] = f;
                    lInedx++;
                }
                unlikedFruits = tempArray;
                //break;
            }
        }
        purchases = freshFruits;
    }

    public FreshCustomer(Fruit[] fruits, String name) {
        super(fruits, name);
        this.purchases = fruits;
        this.name = name;
    }
}
