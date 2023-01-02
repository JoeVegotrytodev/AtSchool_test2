package ru.pflb.vehicles;

import ru.pflb.professions.Driver;
import ru.pflb.details.Engine;

public class SportCar extends Car{
    int maxVelocity;
    //Почему закомментированные строки не работают ????
    //VehicleClass vehicleClass;

    //{
    //    vehicleClass = VehicleClass.SPORTS_CAR;
    //}

    //public SportCar(String model, int weight,
    //Driver driver, Engine engine, int maxVelocity){

   //     super(model, vehicleClass, weight, driver, engine);

    //    this.maxVelocity = maxVelocity;
    //}
    public SportCar(String model, VehicleClass vehicleClass, int weight,
    Driver driver, Engine engine, int maxVelocity){

            super(model, vehicleClass, weight, driver, engine);

            this.maxVelocity = maxVelocity;
    }


    @Override
    public String toString(){
        return "Модель: " + model +", класс: " + vehicleClass + "\n" +
                "Характеристики:" + "\n" +
                "\tвес: " + weight + "\n" +
                "\tдвигатель: " + engine.toString() + "\n" +
                "\tмакс. скорость: " + maxVelocity + "\n" +
                "Водитель: " + driver.toString();
    }
}
