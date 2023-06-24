package mod2les19;

public class Vet {
    String name;

    void treatAnimal(Animal animal){
        animal.health = HealthState.HEALTHY;
    }
}
