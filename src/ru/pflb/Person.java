package ru.pflb;

public abstract class Person {
    public int age;
    public String name;

    public Person(int age, String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString(){
        return name + " " + age + " years old.\n";
    }
}
