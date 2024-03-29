package mod3les10.task1;

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
        else{
            System.out.println("Unknown element...");
            return null;
        }
    }
}
