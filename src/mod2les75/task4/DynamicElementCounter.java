package mod2les75.task4;

public class DynamicElementCounter {
//    - внутренний массив элементов типа ElementCounter
    private ElementCounter[] elementCounter;
//    - конструктор, который на вход принимает целое число - размер внутреннего массива, инициализируется массив указанного размера
    public DynamicElementCounter(int arraySize) {
        elementCounter = new ElementCounter[arraySize];
    }
//    - метод put, который добавляет новый элемент в массив на вход принимает аргумент переменной длины(varargs) строкового типа
    public void put(String... strings){
//    если не передано элементов, то выходим из функции
        if(strings.length < 1){
            return;
        }
        else{
//    если элементы переданы, то для каждого из них выполняем следующие действия:
            for(String strIn : strings){
//    1) вычисляем позицию вставки относительно массива: находим hashCode элемента и находим остаток от его деления на длину внутреннего массива
                int position = strIn.hashCode() / elementCounter.length;
//    2) проверяем массив по полученной позиции: а) если там находится null то создаем новый объект ElementCounter и размещаем на этой позиции в массиве
                if(elementCounter[position] == null){
                    elementCounter[position] = new ElementCounter(strIn);
                }
//    б) если там же там находится объект, то увеличиваем его счетчик этого объекта на 1
                else{
                    elementCounter[position].inc();
                }
            }
        }
    }
//    - метод get, который получает позицию во внутреннем массиве и возвращает объект или null
    public ElementCounter get(int position){
        return elementCounter[position];
    }
//   - метод getSize, который возвращает длинну внутреннего массива
    public int getSize(){
        return elementCounter.length;
    }
}
