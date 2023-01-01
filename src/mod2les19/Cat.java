package mod2les19;

public class Cat extends Animal{
    int counter = 0;
    int foodCounter = 10;

    Cat(String name, String food, String location, HealthState healthState){
        this.name = name;
        this.food = food;
        this.location = location;
        this.health = healthState;
        counter++;
    }

    @Override //использоват ли аннотацию при реализации абстрактных методов ? - ответьте в решении пожалуйста
    public void makeSound(){
        System.out.println("Meow - meow");
    }

    @Override
    public void eat(){
        System.out.println(name + " eats");

        if (foodCounter > 0) {
            foodCounter--;
            System.out.println(foodCounter + " left");
        }
        else {
            System.out.println("There is no more food :C");
        }
    }

    @Override
    public String toString(){
        return name + ": \n" +
                "   Страна обитания: " + location + "\n" +
                "   Состояние здоровья: " + health + "\n" +
                "   Сколько особей: " + counter + "\n\n";
    }
}
