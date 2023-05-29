package mod7les9.task2.vegetables;

public class Cucumber implements Vegetable {

    public String toString(){
        return new Integer(this.hashCode()).toString();
    }

//    @Override
//    public int hashCode(){
//        System.out.println("Hcode = " + name.hashCode());
//        return name.hashCode() - parametr;
//    }
}
