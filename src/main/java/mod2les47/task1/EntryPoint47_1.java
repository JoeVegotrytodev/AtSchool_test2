package mod2les47.task1;

public class EntryPoint47_1 {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]), n = Integer.parseInt(args[1]);

        while (m <= n){
            if((m % 3 == 0) && ((m % 5 != 0))) System.out.println(m);
            m++;
        }
    }
}
