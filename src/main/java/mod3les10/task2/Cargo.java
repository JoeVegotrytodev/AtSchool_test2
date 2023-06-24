package mod3les10.task2;
//находится в пакете com.fruitbase

import mod3les10.task2.fruits.Fruit;

import java.io.Serializable;
import java.math.BigDecimal;

public class Cargo {
    //содержит поле массив Fruit - записи о фруктах, добавленных в груз
    private Fruit[] orderedFruit;
    private double weightSum = 0;
    private BigDecimal priceSum = new BigDecimal(0);
    int putLoc = 0;

    /*
    содержит консткрутор без параметров
    в нем инициализируется внутренний массив
     */
    public Cargo() {
        orderedFruit = new Fruit[0];
    }

    public Cargo(Cargo cargo) {
        this.orderedFruit = cargo.orderedFruit;
    }

    //содержит общедоступный метод getWeight - возвращает суммарный вес груза
    public double getWeight() {
        return weightSum;
    }

    //содержит общедоступный метод getPrice - возвращает суммарную цену груза
    public BigDecimal getPrice() {
        return priceSum;
    }

    //уже спел реализовать этот метод самостоятельно)
    public Fruit[] getFruits() {
        return orderedFruit;
    }

    /*
    содержит метод addFruit, доступный только в пакете
    - добавляет Fruit во внутренний массив
     */
    void addFruit(Fruit fruit) {
        //создаем больший массив
        Fruit[] plusFruit = new Fruit[orderedFruit.length + 1];

        int index = 0;
        for (Fruit f : orderedFruit) {
            plusFruit[index] = f;
            index++;
        }
        //добавляем в него  фрукт
        plusFruit[putLoc] = fruit;
        putLoc++;
        //перезаписываем массив класса Cargo
        orderedFruit = plusFruit.clone();

        //изменияем сумму и вес
        weightSum = weightSum + fruit.getWeight();
        priceSum = priceSum.add(fruit.getPrice());
    }

    @Override
    public String toString() {
        System.out.println("Order :");
        return " weight = " + weightSum + " price = " + priceSum;
    }

//    - общедоступный метод removeFruit
//    получает в качестве параметра фрукт
//    если такого фрукта нет во внутреннем списке, то метод завершается
//    иначе убирает фрукт с указанным названием из внутреннего массива и возвращает его
    public Fruit[] removeFruit(Fruit fruit) {

        //ищем совпадение фрукта
        for (Fruit fruitFromArray : orderedFruit) {
            if (fruit.getName().equals(fruitFromArray.getName()))
                System.out.println("Fruit inside removeFruit " + fruit.getName());
                return deleteFruitFromArray(orderedFruit,fruit);
        }
        return orderedFruit;
    }

    /**
     * Удаляет фрукт из массива фруктов
     * @param fruitArray массив из которого удаляем фрукт
     * @param fruitToDelete фрукт для удаления
     * @return полученный массив без удаленного фрукта
     */
    private Fruit[] deleteFruitFromArray(Fruit[] fruitArray, Fruit fruitToDelete){
        //если фрукт содержиться в массиве
        if(getPosition(fruitArray,fruitToDelete) != -1){
            //удаляем из него фрукт
            return getArrayWithoutFruit(orderedFruit, getPosition(fruitArray,fruitToDelete));
        }
        //иначе возвращем прежний массив
        else return fruitArray;
    }

    /**
     * Возврашает позицию в которой находится фрукт
     * @param fruitArray массив в котором ищем фрукт
     * @param fruitToDelete фрукт позицию которого надо найти
     * @return позицию где находится фрукт
     */
    private int getPosition(Fruit[] fruitArray, Fruit fruitToDelete){
        //ищем позицию фрукта
        for(int i = 0; i < fruitArray.length; i++){
            if(fruitArray[i].getName().equals(fruitToDelete.getName())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Возвращает массив без фрукта
     * @param fruitsArray массив в котором убираем фрукт
     * @param indexToDelete позиция фрукта
     * @return массив без фрукта
     */
    private Fruit[] getArrayWithoutFruit(Fruit[] fruitsArray, int indexToDelete){
        //массив для хранения нужных фруктов, короче изначального на единицу
        Fruit[] fruitsWithoutUseless = new Fruit[fruitsArray.length - 1];
        //его позиция
        int indexOfNewArray = 0;

        //копируем в новый массив эл-ты до позиции удаляемого фрукта
        for(int indexOfFruitArray = 0; indexOfFruitArray < indexToDelete; indexOfFruitArray++){
            fruitsWithoutUseless[indexOfNewArray] = fruitsArray[indexOfFruitArray];
            indexOfNewArray++;
        }

        //копируем в новый массив эл-ты после позиции удаляемого фрукта
        for(int indexOfFruitArray = indexToDelete + 1; indexOfFruitArray < fruitsArray.length; indexOfFruitArray++){
            fruitsWithoutUseless[indexOfNewArray] = fruitsArray[indexOfFruitArray];
            indexOfNewArray++;
        }

        return fruitsWithoutUseless;
    }
}
