package mod2les39.task2;

import mod2les39.task2.Summa.*;

public class EntryPoint {
       public static void main(String[] args) {
        Summa ob = new Summa();
        ob.a = 1;
        ob.b = 2;
        ob.c = 3;
        ob.x = 1.0;
        ob.y = 2.0;
        ob.z = 3.0;

        System.out.println("1: " +  ob.sum(ob.a, ob.b));
        System.out.println("2: " +  ob.sum(ob.a, ob.b, ob.c));
        System.out.print("3: "   +  ob.sum(ob.x, ob.y) + ", ");
        System.out.println(         ob.sum(ob.x, ob.y, ob.z));
        System.out.println("4: " +  ob.sum(ob.x, ob.y, ob.a));
        System.out.println("5: " +  ob.sum_double(ob.b, ob.a));
        System.out.println("6: " +  ob.sum(new Integer(4),new Integer(4)));
    }

}
