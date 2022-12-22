package com.mycompany.app;

//импорты для задания
import com.mycompany.app.cars.Car;
import static com.mycompany.app.cars.Car.move;
import com.mycompany.app.cars.*;
import static com.mycompany.app.cars.Car.*;

//импорты для вывода результата в файл
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    //FileOutputStream требует IOException
    public static void main(String[] args) throws IOException {
        //Создаем объект, передавая путь и параметр разрешающий запись новых данных в след строку,
        //а не автоочищение тем самым , как понимаю, файл открыается для записи
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Я\\IdeaProjects\\AtSchool_test2\\src\\com\\mycompany\\app\\result.txt",
                false);

        //первая запись в файл
        String str = "Вызов статик метода используя полное имя FQDN : ";
        fileOutputStream.write(str.getBytes());
        fileOutputStream.write(com.mycompany.app.cars.Car.move().getBytes());
        //для красивого вывода в новой строчке, может есть способ красивее ?
        str = "\n";
        fileOutputStream.write(str.getBytes());

        //вторая запись в файл
        str = "Вызов статик метода используя обращение к классу : ";
        fileOutputStream.write(str.getBytes());
        fileOutputStream.write(Car.move().getBytes());
        str = "\n";
        fileOutputStream.write(str.getBytes());

        //третья запись в файл
        str = "Вызов статик метода используя статик импорт : ";
        fileOutputStream.write(str.getBytes());
        fileOutputStream.write(move().getBytes());
        str = "\n";
        fileOutputStream.write(str.getBytes());

        //четвертая запись в файл
        Car car_name = new Car();
        str = "Вызов статик метода используя объект класса : ";
        fileOutputStream.write(str.getBytes());
        fileOutputStream.write(car_name.move().getBytes());
        str = "\n";
        fileOutputStream.write(str.getBytes());

        //пятая запись в файл
        str = "Вызов статик метода используя статик импорт класса : ";
        fileOutputStream.write(str.getBytes());
        fileOutputStream.write(Car.move().getBytes());
        str = "\n";
        fileOutputStream.write(str.getBytes());

        //закрыаем файл для записи
        fileOutputStream.close();
    }
}
