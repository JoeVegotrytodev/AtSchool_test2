package mod2les31;

public class Task3 {
//    static boolean flag = false;
    int a;
    int b;

    public static void main(String[] args) {
        Task3 task3 = new Task3();
        task3.a = Integer.parseInt(args[0]);
        task3.b = Integer.parseInt(args[1]);

        System.out.printf("Дано: a =  %s, b = %d", task3.a, task3.b);

        isInteger(task3.a,task3.b);
        System.out.println("\n" + task3.isInteger(task3.a,task3.b));
    }

    static boolean isInteger(int num1, int num2){
        return (num1 % num2) == 0.0;
    }
}
