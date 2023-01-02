package ru.pflb.professions;

import ru.pflb.Person;

public class Driver extends Person {
    int drivingExperience;
    int licenseId;

    public Driver(int age, String name, int drivingExperience, int licenseId){
        super(age, name);

        this.drivingExperience = drivingExperience;
        this.licenseId = licenseId;
    }
    @Override
    public String toString(){
        return name + " - " + age + " years old\n" +
                "\t- стаж: " + drivingExperience + "\n" +
                "\t- № удостоверения: " + licenseId + "\n\n\n";
    }
}
