package com.mycompany.app.cars;

public class Car {
    public static int number = 123;
    //сам метод возвращающий строку
    //сперва сделае, чтобы он печатал фразу с помощью sout, но потом переделал
    //на возвращаемое значение, чтобы в fileOutputStream применить к нему .getBytes()
    //а как с реалзиацией с sout это сделать не придумал... (может будет какой-то совет тут)
    public static String move () { return "zoom-zoom"; }
}
