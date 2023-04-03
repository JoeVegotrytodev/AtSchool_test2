package mod3les10.task1;

import mod3les10.task1.NatureElement;

public class Dust extends NatureElement {

    NatureElement connect(NatureElement elementToConnect){
        System.out.println("There is no new element to connect");
        return null;
    }

    @Override
    public String toString() {
        return "Dust";
    }

}
