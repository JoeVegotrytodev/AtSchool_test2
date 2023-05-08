package mod6les4.task3;

import mod6les4.task3.LowNumbersDeleteQueue;
import mod6les4.task3.Queue;

import java.util.Arrays;

public class QueuesDemo {
    public static void main(String[] args) {

        Queue queue = new Queue();
        for (int i = 0; i < args.length; i++) {
            queue.add(Integer.parseInt(args[i]));
        }
        System.out.println("Очередь #1\nДобавленные элементы: "+ queue.anotherToString());

        Swap asc = (int firstElm, int secondElm) -> firstElm > secondElm;
        queue.sort(asc);
        System.out.println("After sort: " + queue);

        while(!queue.isEmpty()){
            System.out.println("Удален элемент: " + queue.remove() + ", " + queue);
        }
        System.out.println("\n");


        LowNumbersDeleteQueue lowNumbersDeleteQueue = new LowNumbersDeleteQueue();
        for (int i = 0; i < args.length; i++) {
            lowNumbersDeleteQueue.add(Integer.parseInt(args[i]));
        }
        System.out.println("Очередь #2\nДобавленные элементы: "+ lowNumbersDeleteQueue.anotherToString());

        lowNumbersDeleteQueue.sort((int firstElm, int secondElm) -> firstElm < secondElm);
        System.out.println("After sort: " + lowNumbersDeleteQueue);

        while(!lowNumbersDeleteQueue.isEmpty()){
            System.out.println("Удален элемент: " + lowNumbersDeleteQueue.remove() + ", " + lowNumbersDeleteQueue);
        }

    }
}
