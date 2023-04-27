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

        Swap asc = (int firstElm, int secondElm) -> firstElm > secondElm;
        queue.sort(asc);
        System.out.println("After sort: " + queue);

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

        Swap desc = (int firstElm, int secondElm) -> firstElm < secondElm;
        lowNumbersDeleteQueue.sort(desc);
        System.out.println("After sort: " + lowNumbersDeleteQueue);

        while(!lowNumbersDeleteQueue.isEmpty()){
            lowNumbersDeleteQueue.remove();
            System.out.println("Remove lower element " + lowNumbersDeleteQueue);
        }

    }
}
