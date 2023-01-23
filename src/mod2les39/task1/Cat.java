package mod2les39.task1;

public class Cat {
    int years;
    String eyeColor;
    String woolColor;
    //- добавил переменную
    int weight;

    /* пришлось переделать c 3 переменных и 8 конструкторов,
    на 4 перменных ужс сколько конструкторов, переставлять одни и те же переменные очень увлекательно
    причем я уверен, что еще не всевозможные перечислил

    Cat(int years, String eyeColor, String woolColor){
        this.years = years;
        this.eyeColor = eyeColor;
        this.woolColor = woolColor;
    }
    Cat(int years, String eyeColor){
        this(years, eyeColor, "black");
    }
    Cat(String woolColor, int years){
        this(years, "yellow", woolColor);
    }
    Cat(String woolColor, String eyeColor){
        this(1, eyeColor, woolColor);
    }
    Cat(String eyeColor, int years, String woolColor){
        this.years = years;
        this.eyeColor = eyeColor;
        this.woolColor = woolColor;
    }
    Cat(String eyeColor, String woolColor, int years){
        this.years = years;
        this.eyeColor = eyeColor;
        this.woolColor = woolColor;
    }
    Cat(int years){
        this(years, "yellow", "black");
    }
    Cat(String eyeColor){
        this(1, eyeColor, "black");
    }*/

    Cat(int years, String eyeColor, String woolColor, int weight){
        this.years = years;
        this.eyeColor = eyeColor;
        this.woolColor = woolColor;
        this.weight = weight;
    }

    Cat(int years, int weight, String eyeColor, String woolColor){
        this.years = years;
        this.eyeColor = eyeColor;
        this.woolColor = woolColor;
        this.weight = weight;
    }

    Cat(int years, String eyeColor, int weight, String woolColor){
        this.years = years;
        this.eyeColor = eyeColor;
        this.woolColor = woolColor;
        this.weight = weight;
    }

    Cat(String eyeColor, int years, int weight, String woolColor){
        this.years = years;
        this.eyeColor = eyeColor;
        this.woolColor = woolColor;
        this.weight = weight;
    }

    Cat(String eyeColor, String woolColor, int years, int weight){
        this.years = years;
        this.eyeColor = eyeColor;
        this.woolColor = woolColor;
        this.weight = weight;
    }

    Cat(String eyeColor, int weight, String woolColor, int years){
        this.years = years;
        this.eyeColor = eyeColor;
        this.woolColor = woolColor;
        this.weight = weight;
    }

    Cat(int years, String eyeColor, String woolColor){
        this(years, eyeColor, woolColor, 2);
    }

    Cat(String eyeColor, int years, String woolColor){
        this(years, eyeColor, woolColor, 3);
    }

    Cat(String eyeColor, String woolColor, int years){
        this(years, eyeColor, woolColor, 4);
    }

    Cat(int years, int weight, String eyeColor){
        this(years, eyeColor, "white", weight);
    }

    Cat(int years, String eyeColor, int weight){
        this(years, eyeColor, "yellow", weight);
    }

    Cat(String eyeColor, int years, int weight){
        this(years, eyeColor, "black", weight);
    }

    Cat(int years, int weight){
        this(years, "blue", "black", weight);
    }

    Cat(int years, String eyeColor){
        this(years, eyeColor, "black", 5);
    }

    Cat(String eyeColor, int weight){
        this(2, eyeColor, "black", weight);
    }

    Cat(String eyeColor, String woolColor){
        this(2, eyeColor, woolColor, 4);
    }

    Cat(String woolColor){
        this(2, "blue", woolColor, 4);
    }

    Cat(int weight){
        this(2, "blue", "black", weight);
    }

    Cat(){
        this(2, "blue", "black", 8);
    }

    @Override
    public String toString(){
        return "Cat " + years + " years old, has a " + eyeColor + " eyes and " + woolColor + " wool and his weight " + weight;
    }
}
