package mod2les39.task2;

import mod2les39.task2.Summa.*;

public class EntryPoint {
       public static void main(String[] args) {
        Summa ob = new Summa();
        int a = 1;
        int b = 2;
        int c = 3;
        double x = 1.0;
        double y = 2.0;
        double z = 3.0;


        System.out.println("1: " +  ob.sum(a, b));
        System.out.println("2: " +  ob.sum(a, b, c));
        System.out.print("3: " +  ob.sum(x, y) + ", ");
        System.out.println(ob.sum(x, y, z));
        System.out.println("4: " +  ob.sum(x, y, a));
        //убрали из задания
        //System.out.println("5: " +  ob.sum_double(b, a));
        System.out.println("5: " +  ob.sum(new Integer(4),new Integer(4)));
    }

}
