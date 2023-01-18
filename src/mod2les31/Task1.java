package mod2les31;

public class Task1 {
    public static void main(String[] args) {
        int a = 4;
        int b = 5;
//        System.out.println("Дано: a =  " + a + ", b = " + b);
        System.out.println(String.format("Дано: a = %s, b = %s", a, b));

        int temp = a;
        a = b;
        b = temp;
//        System.out.println("После перестановки: a =  " + a + ", b = " + b);
        System.out.println(String.format("После перестановки: a = %d, b = %d", a, b));
    }
}
