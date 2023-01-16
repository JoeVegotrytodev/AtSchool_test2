package mod2les31;

public class Task2 {
    public static void main(String[] args) {
        int a = 4;
        int b = 5;
        System.out.println("Дано: a =  " + a + ", b = " + b);

        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("После перестановки: a =  " + a + ", b = " + b);

    }
}
