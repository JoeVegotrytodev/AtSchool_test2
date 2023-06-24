package mod5les5.task1;

import mod5les5.task1.elements.NatureElement;

import java.util.NoSuchElementException;

public class Alchemy {
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
