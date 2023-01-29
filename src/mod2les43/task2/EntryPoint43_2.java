package mod2les43.task2;

public class EntryPoint43_2 {
    public static void main(String[] args) {

        for (int i = 0; i < 7; i++){
            if (Integer.parseInt(args[i]) < 8) {
                switch (Integer.parseInt(args[i])){
                    case 1 :
                        System.out.println("Понедельник");
                        break;
                    case 2 :
                        System.out.println("Вторник");
                        break;
                    case 3 :
                        System.out.println("Среда");
                        break;
                    case 4 :
                        System.out.println("Четерг");
                        break;
                    case 5 :
                        System.out.println("Пятница");
                        break;
                    case 6 :
                        System.out.println("Суббота");
                        break;
                    case 7 :
                        System.out.println("Воскресенье");
                        break;
                }
            }
            else {
                System.out.println("упс... число вне диапазона");
                return;
            }
        }

    }
}
