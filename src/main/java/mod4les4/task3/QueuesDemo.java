package mod4les4.task3;

import java.util.Arrays;

public class QueuesDemo {
    public static void main(String[] args) {
        Queue queue = new Queue();
        for (int i = 0; i < args.length; i++) {
            queue.add(Integer.parseInt(args[i]));
        }
        System.out.println("Очередь #1\nДобавленные элементы: " + queue.anotherToString());

        while (!queue.isEmpty()) {
            System.out.println("Удален элемент: " + queue.remove() + ", " + queue);
        }
        System.out.println("\n");


        LowNumbersDeleteQueue lowNumbersDeleteQueue = new LowNumbersDeleteQueue();
        for (int i = 0; i < args.length; i++) {
            lowNumbersDeleteQueue.add(Integer.parseInt(args[i]));
        }
        System.out.println("Очередь #2\nДобавленные элементы: " + lowNumbersDeleteQueue.anotherToString());

        while(!lowNumbersDeleteQueue.isEmpty()){
            System.out.println("Удален элемент: " + lowNumbersDeleteQueue.remove() + ", " + lowNumbersDeleteQueue);
        }
    }
}
