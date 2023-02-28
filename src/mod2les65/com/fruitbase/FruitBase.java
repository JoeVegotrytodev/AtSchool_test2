//находится в пакете com.fruitbase
package mod2les65.com.fruitbase;

public class FruitBase {
    //содержит поле FruitCatalogue
    private FruitCatalogue catalogue;
    Cargo cargo;

    /*
    содержит конструктор без параметров
    в нем инициализируется поле FruitCatalogue
     */
    public FruitBase() {
        catalogue = new FruitCatalogue();
        cargo = new Cargo();
    }

    /*
    содержит общедоступный метод для обработки заказа takeOrder
        в этом методе происходит поиск слов из заказа в FruitCatalogue
        если хотя бы одно название найдено,
        то формируется груз Cargo с информацией о найденных фруктах
     */
    public Cargo takeOrder(String orderedFruit) {

        if(catalogue.findFruit(orderedFruit) != null) {
            //формируется груз Cargo с информацией о найденных фруктах
            cargo.addFruit(catalogue.findFruit(orderedFruit));
            return cargo;
        }
        // Если среди запроса не встретились известные названия,
        // то возвращается груз Cargo с нулевым количеством фруктов
        else
            return null;
    }


    public static void main(String[] args) {
        //создается фруктовая база
        FruitBase base = new FruitBase();

        /*
        Если передан "пустой запрос" (не переданы аргументы), то программа завершается.
         */
        if(args.length == 0){
            System.out.println("args is empty");
            return;
        }


        for(int i = 0; i < args.length; i++){
            base.takeOrder(args[i]);
            if(i == args.length - 1)
                System.out.println(base.takeOrder(args[i]) + "\n");
        }

    }
}
