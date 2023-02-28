package mod2les65.com.blackjack.cards;
//находится в пакете cards

enum CardType {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10),
    ACE(11);

    //параметр очки
    private final int points;

    //конструктор, который устанавливает значение очков
    CardType(int points) {
        this.points = points;
    }

    /*
    метод, доступный в пакете, getPoints
    возвращает число очков для типа
     */
    int getPoints(){
        return points;
    }
}
