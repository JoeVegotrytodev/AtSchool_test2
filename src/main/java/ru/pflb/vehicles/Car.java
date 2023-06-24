package ru.pflb.vehicles;

import ru.pflb.details.Engine;
import ru.pflb.professions.Driver;

public class Car {
    String model;
    VehicleClass vehicleClass;
    int weight;
    Driver driver;
    Engine engine;

    public Car(String model, VehicleClass vehicleClass, int weight,
        Driver driver, Engine engine){

        this.model = model;
        this.vehicleClass = vehicleClass;
        this.weight = weight;
        this.driver = driver;
        this.engine = engine;
    }

    public static void start(){
        System.out.println("Поехали");
    }

    public static void stop(){
        System.out.println("Останавливаемся");
    }

    public static void turnRight(){
        System.out.println("Поворот направо");
    }

    public static void turnLeft(){
        System.out.println("Поворот налево");
    }

    @Override
    public String toString(){
        return "Модель: " + model +", класс: " + vehicleClass + "\n" +
                "Характеристики:" + "\n" +
                "\tвес: " + weight + "\n" +
                "\tдвигатель: " + engine.toString() + "\n" +
                "Водитель: " + driver.toString();
    }


}
