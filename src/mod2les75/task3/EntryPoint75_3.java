package mod2les75.task3;

import java.util.Random;

public class EntryPoint75_3 {
    public static void main(String[] args) {
        int l = 512;
        int n = 10 ;
        int m = 5;
//        Напишите программу, в которой выполняются l итераций следующих действий:
//        1) Выводится номер итерации
//      2) создается массив из n элеметов типа Element, значение каждого элемента = порядковому номеру + l.
//      3) случайным образом выбирается элемент и "уничтожается" (в массив на эту позицию записывается null).
//   Это продолжается пока в массиве не останется m элементов, отличных от null.
        for(int index = 0; index <= l; index++){
            System.out.println("Iteration " + index);

            Element[] elements = new Element[n];
            for(int jindex = 0; jindex < n; jindex++){
                elements[jindex] = new Element(n + 1);
            }

            int startPos = 0,
                    endPos = n,
                    range =  endPos - startPos;
            Random random = new Random();
            boolean elementsRemoved = false;
            int jindex = 0;


            while(elements[jindex] != null & !elementsRemoved){
                int randPosition = random.nextInt(range) + startPos;
                elements[randPosition] = null;
                jindex++;

                int counterOfRemoved = 0;
                for(Element el : elements){
                    if(el == null)
                        counterOfRemoved++;

                    if(counterOfRemoved > n - m){
                        elementsRemoved = true;
                        break;
                    }
                }
            }

//        System.gc();
//        System.runFinalization();
        }
//        System.gc();
//        System.runFinalization();
    }
}
