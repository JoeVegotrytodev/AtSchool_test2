package com.mycompany.app;

import static com.mycompany.app.cars.Car.move;
import static com.mycompany.app.cars.Car.*;

public class mod2task14 {
    public static void main(String[] args) {
        System.out.println("FQDN импорт com.mycompany.app.cars.Car.move() : " + com.mycompany.app.cars.Car.move());
        System.out.println("Импорт статик импорта : " + move());
    }

}
