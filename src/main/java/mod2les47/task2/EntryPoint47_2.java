package mod2les47.task2;

public class EntryPoint47_2 {
    public static void main(String[] args) {
        /*Получаем аргументы командной строки. Делаем проверку, что n и m больше нуля.
        В противном случае выведите сообщение об ошибке и завершите программу.*/
        if((Integer.parseInt(args[0]) < 0) | (Integer.parseInt(args[1]) < 0)) {
            System.out.println("args are less tha zero");
            return;
        }

        //перевел в минуты для удобства подсчета
        int machinesAmount = Integer.parseInt(args[0]);
        int workTimeOfFirstMachine = Integer.parseInt(args[1]) * 60;
        //для хранения времени всей работы
        int additionalMinutes = 0;
        //подсчет общего времени
        int workTime = workTimeOfFirstMachine;

        //Напишите программу, вычисляющую количество сколько часов проработала вся бригада.
        for(int i = 1; i < machinesAmount; i++){
            additionalMinutes += 10;
            workTime += (workTimeOfFirstMachine + additionalMinutes);
        }
        //Результат вычислений выведите на экран в часах и минутах.
        System.out.println("Бригада работала " + workTime / 60 + " часов " + workTime % 60 + " минут.");
    }
}
