package mod2les31;

public class Task3 {
    static boolean flag = false;
    static int a;
    static int b;

    public static void main(String[] args) {
        a = Integer.parseInt(args[0]);
        b = Integer.parseInt(args[1]);
        System.out.println("Дано: a =  " + a + ", b = " + b);

        isInteger(a,b);

        System.out.println("\n" + flag);
    }

    static void isInteger(int num1, int num2){
        flag = (a % b) == 0.0;
    }
}
