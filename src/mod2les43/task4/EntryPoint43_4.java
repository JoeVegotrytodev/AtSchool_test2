package mod2les43.task4;

import static java.lang.Math.pow;

public class EntryPoint43_4{
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]), b = Integer.parseInt(args[1]),
                c = Integer.parseInt(args[2]);

        //вынес в методы, чтобы конструкция читалась проще
        if (isRight(a,b,c)) System.out.println("Right");
        else if (isObtuse(a,b,c)) System.out.println("Obtuse");
        else if (isAcute(a,b,c)) System.out.println("Acute");
        else System.out.println("Impossible");

    }
    static boolean isRight(int a, int b, int c){
        if (pow(a, 2) == pow(b, 2) + pow(c, 2)) return true;
        else if (pow(b, 2) == pow(a, 2) + pow(c, 2)) return true;
        else if (pow(c, 2) == pow(a, 2) + pow(b, 2)) return true;
        else return false;
    }
    static boolean isAcute(int a, int b, int c){
        if (pow(a, 2) + pow(b, 2) > pow(c, 2)) return true;
        else if (pow(a, 2) + pow(c, 2) > pow(b, 2)) return true;
        else if (pow(c, 2) + pow(b, 2) > pow(a, 2)) return true;
        else return false;
    }
    static boolean isObtuse(int a, int b, int c){
        if (pow(a, 2) + pow(b, 2) < pow(c, 2)) return true;
        else if (pow(a, 2) + pow(c, 2) < pow(b, 2)) return true;
        else if (pow(c, 2) + pow(b, 2) < pow(a, 2)) return true;
        else return false;
    }
}
