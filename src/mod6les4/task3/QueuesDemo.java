package mod6les4.task3;

import java.util.Arrays;

public class QueuesDemo {
    public static void main(String[] args) {
        Queue queue = new Queue();

        System.out.println("Original input " + Arrays.toString(args));
        for (int i = 0; i < args.length; i++) {
            queue.add(Integer.parseInt(args[i]));
            System.out.println("Add new element " + queue);
        }

        while(!queue.isEmpty()){
            queue.remove();
            System.out.println("Remove element " + queue);
        }
        System.out.println("\n");



        LowNumbersDeleteQueue lowNumbersDeleteQueue = new LowNumbersDeleteQueue();
        System.out.println("Original input " + Arrays.toString(args));

        for (int i = 0; i < args.length; i++) {
            lowNumbersDeleteQueue.add(Integer.parseInt(args[i]));
            System.out.println("Add new element " + lowNumbersDeleteQueue);
        }
        while(!lowNumbersDeleteQueue.isEmpty()){
            lowNumbersDeleteQueue.remove();
            System.out.println("Remove lower element " + lowNumbersDeleteQueue);
        }

    }
}
