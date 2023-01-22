package mod2les39.task1;

public class Cat {
    int years;
    String eyeColor;
    String woolColor;

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
    }

    @Override
    public String toString(){
        return "Cat " + years + " years old, has a " + eyeColor + " eyes and " + woolColor + " wool";
    }
}
