package mod2les19;

public abstract class Animal {
    String name;
    String food;
    String location;
    int counter;
    int foodCounter;
    HealthState health;

    public abstract void makeSound();
    public abstract void eat();
    public void sleep(){
        System.out.println("Tss, animal sleeps.....");
    }
}
