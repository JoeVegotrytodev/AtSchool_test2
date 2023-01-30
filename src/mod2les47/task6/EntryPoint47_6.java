package mod2les47.task6;

public class EntryPoint47_6 {
    public static void main(String[] args) {
        //Нужно проверить, что введенное число больше или равно нуля.
        //В противном случае выведите сообщение об ошибке
        //и завершите программу.
        if(Integer.parseInt(args[0]) < 0){
            System.out.println("Seconds less than zero");
            return;
        }

        //Напишите программу-таймер обратного отсчета в минутах и секундах,
        //используя созданные класс Timer.
        //Через аргументы командной строки передается число секунд.
        Timer timer = new Timer(Integer.parseInt(args[0]));
        timer.start();
    }
}
