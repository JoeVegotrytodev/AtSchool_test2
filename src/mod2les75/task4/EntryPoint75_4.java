package mod2les75.task4;

import mod2les75.task1.EntryPoint75_1;

//Для метода main используйте отдельный класс.
public class EntryPoint75_4 {
    public static void main(String[] args) {
//        Попробуйте с помощью класса DynamicElementCounter решить первую задачу, используя различные значения size.
        if (args.length == 0) {
            System.out.println("Original string : ");
            System.out.println("String after deleting matches : ");
        }
        else{
            System.out.println("Original string : ");
            EntryPoint75_1.printStrings(args);
            System.out.println("\n\nString after deleting matches : ");

            DynamicElementCounter dynamicElementCounter = new DynamicElementCounter(1000);
            dynamicElementCounter.put(args);
            for(int i = 0; i < dynamicElementCounter.getSize(); i++){
                System.out.println(dynamicElementCounter.get(i));
            }
        }
    }
}
