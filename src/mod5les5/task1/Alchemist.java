package mod5les5.task1;

import java.util.NoSuchElementException;

public class Alchemist {
//    через аргументы командной строки передаются названия элементов
//    для переданных аргументов создаются объекты соответствующих классов.
//    Если хотя бы для одного из аргументов нельзя создать объект, то программа завершается.
//    Далее попарно объединяются объекты и выводятся соответствующие сообщения.
//    Т.е. для объектов Air Air Fire Earth в результате объединения получатся два объекта: Pressure и Lava
    public static void main(String[] args) {
        NatureElement[] elementsArray = new NatureElement[args.length];

        for(int index = 0; index < args.length; index++){
            try {
                elementsArray[index] = NatureElement.create(args[index]);
            }
            catch (NoSuchElementException exc){
                System.out.println("Unknown element...");
                return;
            }
        }


        for(int index = 0; (index < elementsArray.length) & (index + 1 <= elementsArray.length - 1); index+=2){
            try{
                elementsArray[index].connect(elementsArray[index+1]);
            }
            catch(UnsupportedOperationException exc){
                System.out.println("Операция не поддерживается");
            }
        }
    }
}
