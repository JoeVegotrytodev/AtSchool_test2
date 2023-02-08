package mod2les43.task2;

public class EntryPoint43_2 {
    public static void main(String[] args) {
        /*
        для чего испльзуешь вот тут перебор? Если я передам только 1 знаечение
        у меня будет выход за пределы массива. цикл for впринципе излишен тут

        Добавлял так просто для себя, чтобы все дни недели вывести.
        Сделал как по задаче, что передается число через аргументы строки
         */

        int number = Integer.parseInt(args[0]);

        if((1 > number) | (number > 7)){
            System.out.println("Arg out of range 1-7");
            return;
        }

        switch(number) {
            case 1:
                System.out.println("Понедельник");
                break;
            case 2:
                System.out.println("Вторник");
                break;
            case 3:
                System.out.println("Среда");
                break;
            case 4:
                System.out.println("Четерг");
                break;
            case 5:
                System.out.println("Пятница");
                break;
            case 6:
                System.out.println("Суббота");
                break;
            case 7:
                System.out.println("Воскресенье");
                break;
        }
    }
}
