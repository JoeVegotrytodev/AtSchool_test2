package mod2les39.task1;

import mod2les39.task1.Cat.*;

public class EntryPoint {
    public static void main(String[] args) {
        System.out.println(new Cat(10));
        System.out.println(new Cat("blue"));
        System.out.println(new Cat("blue", "white", 4));
        System.out.println(new Cat("blue", 2, "black"));
        System.out.println(new Cat("brown", "gray"));
        System.out.println(new Cat("gray", 5));
        System.out.println(new Cat(3, "brown"));
        System.out.println(new Cat(6, "brown", "white"));
    }
}
