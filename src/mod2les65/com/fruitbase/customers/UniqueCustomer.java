package mod2les65.com.fruitbase.customers;

import mod2les65.com.fruitbase.fruits.Fruit;

public class UniqueCustomer extends Customer {

    public UniqueCustomer(Fruit[] fruits, String name) {
        super(fruits, name);
        this.purchases = fruits;
        this.name = name;
    }

//    реалиация метода takeFruits отбирает только уникальные фрукты,
//    т.е. те, которых еще нет во внутреннем массиве
    public void takeFruits() {
        //создаем массив уникальных фруктов хранящий уникальные фрукты
        Fruit[] uniqueFruits = new Fruit[getPurchases().length];
        //хранит номер эл-та массива уникальных фруктов
        int uniqueFruitIndex = 0;

        //проходим по массиву заказа пользователя
        for (Fruit f : getPurchases()) {
            //заканчиваем цикл если содержим эл-т нулл
            if(f == null)
                break;

            //в 0 эл-т сохраняем первое значение заказа
            if (uniqueFruitIndex == 0) {
                uniqueFruits[uniqueFruitIndex] = f;
                uniqueFruitIndex++;
                continue;
            }

            //флаг уникальности заказа
            boolean isUnique = true;

            //вложенный ЦИКЛ !!!!!
            //проходим по уникальным фруктам
            for(int i = 0; i < uniqueFruits.length; i++) {
                if(uniqueFruits[i] == null)
                    break;


                if(f.getName().equals(uniqueFruits[i].getName())) {
                    //отмена уникальности и прерывание цикла
                    //isUnique = false;
//                    созадем больший массива
                    Fruit[] tempArray = new Fruit[unlikedFruits.length + 1];
                    //копируем туда эл-ты
                    int lInedx = 0;
                    if (unlikedFruits.length > 0) {
                        for(Fruit frt : unlikedFruits){
                            //если это нулл эл-т то прерываем
                            if(frt == null){
                                break;
                            }

                            tempArray[lInedx] = frt;
                            lInedx++;
                        }
                    }
                    else{
                        tempArray[lInedx] = f;
                        lInedx++;
                    }
                    unlikedFruits = tempArray;
                    break;
                }
                //если фрукт уникален
                else{
                    //создаем больший массив УНИКАЛЬНЫХ фруктов
                    Fruit[] tempArray = new Fruit[uniqueFruits.length + 1];
                    //для индекса временного массива
                    int kIndex = 0;

                    //каждый эл-т уникальных фрутков копируем в новый массив
                    for(Fruit fr : uniqueFruits){
                        tempArray[kIndex] = fr;
                        //зменяем индкса временного массива
                        kIndex++;
                    }
                    //
                    tempArray[kIndex] = f;

                    //jIndex = kIndex + 1;

                    uniqueFruits = tempArray;
                    //unlikedFruits[jIndex] = f;
                    //jIndex++;
                }
            }

        }

        purchases = uniqueFruits;
    }

//    private Fruit[] saveFirstElementToArray(Fruit fruit){
//        Fruit[] resFruit = new
//    }
}
