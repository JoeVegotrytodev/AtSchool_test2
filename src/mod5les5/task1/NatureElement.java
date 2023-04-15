package mod5les5.task1;

import java.util.Locale;

//Напишем программу, которая реализует смешивание элементов для зелья. Для этого реализуйте:
//- родительский класс всех элементов NatureElement
public abstract class NatureElement {
//    содержит метод connect, который в качестве параметра получает другой NatureElement
//    содержит пустое тело
    abstract NatureElement connect(NatureElement elementToConnect);
//    содержит статический метод create
//    в качестве параметра принимает строку - название базового элемента
//    по названию создает базовый элемент
//    если название неизвестно, то печатается сообщение "Неизвестный элемент" и возвращается null.
    public static NatureElement create(String baseElementName){
        baseElementName = baseElementName.toLowerCase(Locale.ROOT);

        if(baseElementName.equals(new Fire().toString().toLowerCase(Locale.ROOT)))
            return new Fire();
        else if(baseElementName.equals(new Water().toString().toLowerCase(Locale.ROOT)))
            return new Water();
        else if(baseElementName.equals(new Air().toString().toLowerCase(Locale.ROOT)))
            return new Air();
        else if(baseElementName.equals(new Earth().toString().toLowerCase(Locale.ROOT)))
            return new Earth();
        else if(baseElementName.equals(new Energy().toString().toLowerCase(Locale.ROOT)))
           return new Energy();
        else{
            /*в методе create класса NatureElement, если встретился неизвестный элемент,
     то бросается java.util.NoSuchElementException, которое обрабатывается в основном классе Alchemy.
     При обработке программа завершается.
             */
            throw new java.util.NoSuchElementException();
        }
    }
}
