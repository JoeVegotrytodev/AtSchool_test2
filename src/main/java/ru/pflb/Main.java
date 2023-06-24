package ru.pflb;

import ru.pflb.details.Engine;
import ru.pflb.professions.Driver;
import ru.pflb.vehicles.*;

public class Main {
    public static void main(String[] args) {
        Driver nicky = new Driver(70,"Ники Лауда", 40, 2202949);
        Driver senna = new Driver(35,"Айртон Сенна", 20, 21031960);
        Driver gocha = new Driver(36,"Георгий Чивчян", 20, 21011986);

        Engine h4mk = new Engine(113, "Renault");
        Engine vq30dett = new Engine(280,"Nissan");
        Engine yamz534 = new Engine(190,"YAMZ");


        Lorry gazelle = new Lorry("gazelle", VehicleClass.MEDIUM, 2000, nicky, yamz534,2000);
        SportCar fairladyZ = new SportCar("fairladyZ", VehicleClass.SPORTS_CAR, 1570, senna, vq30dett, 250);
        Car vesta = new Car("vesta", VehicleClass.SMALL, 1300, gocha, h4mk);

        System.out.println(gazelle.toString() + fairladyZ.toString() + vesta.toString());
    }
}
