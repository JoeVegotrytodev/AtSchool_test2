package mod2les39.task3;

public class Cat extends Animal{
    /*static String testStaticMethod(){
        return "Child's testStaticMethod";
    }*/

    public static void main(String[] args) {
        System.out.println(Animal.testStaticMethod());
        System.out.println(Cat.testStaticMethod());
        System.out.println(testStaticMethod());
    }
}
