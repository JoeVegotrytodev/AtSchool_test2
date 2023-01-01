package mod2les19;

public class EntryPoint {

    public static void main(String[] args){
        //- добавьте переменные в классов Dog, Cat, Horse
        Dog doge = new Dog("doge", "bones", "Izhevsk", HealthState.HEALTHY);
        Cat salem = new Cat("salem", "whiskas", "Moscow", HealthState.HEALTHY);
        Horse eclipse = new Horse("eclipse", "seed", "San Jose", HealthState.HEALTHY);

        //- выведите внутреннию информацию о каждой особи
        //почему тут варнинг ненужный вызов ту стринг - 3 штуки : Unnecessary 'toString()' call
        //как улучшить код, чтобы не ругался
        System.out.println(doge.toString() + salem.toString() + eclipse.toString());

        //- выведите результат makeSound для каждой особи
        doge.makeSound();
        salem.makeSound();
        eclipse.makeSound();
        System.out.println("\n");

        //- вызовите метод eat у некоторых животных
        salem.eat();
        eclipse.eat();
        System.out.println("\n");

        //- создайте ветеринара и отведите каждого животного на прием
        doge.health = HealthState.UNHEALTHY;
        Vet airat = new Vet();
        airat.treatAnimal(doge);
        System.out.println("Doge " + doge.health + "\n");

        //- вызовите метод sleep у некоторых животных
        salem.sleep();
        eclipse.sleep();

    }
}
