package mod2les43.task5;

public class EntryPoint43_5 {
    public static void main(String[] args) {
        /*
        Изменил объявление и инициализацию интов.
        И букву С в сдаче:)
         */
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        int d = Integer.parseInt(args[3]);

        if (a < 0 | b < 0 | c < 0 | d < 0){
            System.out.println("Error numbers are less than zero");
            return;
        }

        int price = a * 100 + b, payment = c * 100 + d;

        if ((price) > (payment)){
            System.out.println("Error not enough money");
        }
        else System.out.println("Сдача " + ((payment - price) / 100) + " рублей и " +
                "" + ((payment - price) % 100) + " копеек");
    }
}
