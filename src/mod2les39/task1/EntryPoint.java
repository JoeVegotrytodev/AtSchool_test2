package mod2les39.task1;

import mod2les39.task1.Cat.*;

public class EntryPoint {
    public static void main(String[] args) {
        //System.out.println(new Cat());
        System.out.println(new Cat());
        System.out.println(new Cat(5));
        System.out.println(new Cat("violet"));

        System.out.println(new Cat("yellow", "yellow"));
        System.out.println(new Cat("blue", 9));
        System.out.println(new Cat(7, "green"));
        System.out.println(new Cat(5,10));

        System.out.println(new Cat("green", 3, 3));
        System.out.println(new Cat(5,"green",5));
        System.out.println(new Cat(5, 6, "green"));
        System.out.println(new Cat("blue", "black", 8));
        System.out.println(new Cat("green", 3, "white"));
        System.out.println(new Cat(7, "grey", "orange"));

        System.out.println(new Cat("blue", 4, "green", 9));
        System.out.println(new Cat("yellow", "white", 7,7));
        System.out.println(new Cat("grey", 5,5,"black"));
        System.out.println(new Cat(8, "green", 6, "brown"));
        System.out.println(new Cat(9,9,"brown", "white"));
        System.out.println(new Cat(6, "brown", "white", 10));
    }
}
