package mod2les47.task6;

public class Timer {
    // - целочисленное поле seconds - общее число секунд, устанавливается в конструкторе
    int seconds;

    Timer(int seconds){
        this.seconds = seconds;
    }

    //- статический метод void waitSecond() - метод реализует паузу
    //одной секунды. Реализовать с помощью цикла.
    static void waitSecond(){
        long currentTime = System.currentTimeMillis();
        for(;;){
            if(currentTime == System.currentTimeMillis() + 1);
            break;
        }
    }

    // - метод printTime вывода оставшегося времени в минутах и секундах.
    void printTime(){
        //сперва сделал так, но вывод не соотвестувет ождаемому результату
        //System.out.println(seconds / 60 + ":" + seconds % 60);

        //переделал так, но наверное должны быть способы попроще
        if(((seconds / 60) < 10) & ((seconds % 60) < 10)) System.out.println("0"
                + seconds / 60 + ":" + "0" + seconds % 60);
        else if(((seconds / 60) >= 10) & ((seconds % 60) >= 10)) System.out.println(
                seconds / 60 + ":" + seconds % 60);
        else if(((seconds / 60) >= 10) & ((seconds % 60) < 10)) System.out.println(
                seconds / 60 + ":" + "0" + seconds % 60);
        else if(((seconds / 60) < 10) & ((seconds % 60) >= 10)) System.out.println("0"
                + seconds / 60 + ":" + seconds % 60);
    }

    //- объектный метод start() - запускает обратный отсчет
    //и каждую секунды выводит оставшееся количество секунд.
    void start(){
        printTime();
        do{
            seconds--;
            waitSecond();
            printTime();
        }while(seconds != 0);

    }
}
