package mod2les31;


public class Task4 {
    static int p;
    static int t;
    static double r;

    public static void main(String[] args) {
        /*p = Integer.parseInt(args[0]);
        t = Integer.parseInt(args[1]);
        r = Double.parseDouble(args[2]);
        System.out.println("Дано: p =  " + p + ", t = " + r + ", r = " + t);*/
        System.out.println(String.format("Дано: p = %s, t = %s, r = %s",
                Integer.parseInt(args[0]),Integer.parseInt(args[1]),Double.parseDouble(args[2])));
        System.out.println(calculation(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Double.parseDouble(args[2])));
    }

    static double calculation(int sum, int years, double percent){
        return Math.exp(years * percent) * sum;
    }

}
