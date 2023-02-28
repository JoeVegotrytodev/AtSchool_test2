package mod2les65.com.blackjack.cards;
//находится в пакете cards

import java.util.Random;

public class Card {
    //содержит внутреннее поле тип карты CardType
    private CardType cardType;
    //содержит внутреннее поле масть карты CardSuit
    private CardSuit cardSuit;

    /*
    общедоступный метод setCardType
        устанавливает значение типа карты
     */
    public void setCardType(CardType receivedType){
        this.cardType = receivedType;
    }

    /*
    общедоступный метод setCardSuit
        устанавливает значение масти
     */
    public void setCardSuite(CardSuit receivedSuit){
        this.cardSuit = receivedSuit;
    }

    /*
    общедоступный метод getPoints
        возвращает число очков карты
     */
    public int getPoints(){
        return cardType.getPoints();
    }

    /*
    общедоступный метод toString
        возвращает строку с типом и мастью карты (без очков)
     */
    @Override
    public String toString(){
        return "Card type is " + cardType + ", cardSuit is " + cardSuit;
    }

    /*
    Решил вынести в отдельный метод генерацию карты,
    из-за рандома потому что получается слишком большой код
    так и получился конструктор...
     */
    public Card() {
        int maxValue = 13;
        int minValue = 1;
        int range = maxValue - minValue + 1;

        Random random = new Random();
        int randomize = random.nextInt(range)+ minValue;

        //рандом условный типа карты
        switch(randomize){
            case 1 : {
                this.setCardType(CardType.TWO);
                break;
            }
            case 2 : {
                this.setCardType(CardType.THREE);
                break;
            }
            case 3 : {
                this.setCardType(CardType.FOUR);
                break;
            }
            case 4 : {
                this.setCardType(CardType.FIVE);
                break;
            }
            case 5 : {
                this.setCardType(CardType.SIX);
                break;
            }
            case 6 : {
                this.setCardType(CardType.SEVEN);
                break;
            }
            case 7 : {
                this.setCardType(CardType.EIGHT);
                break;
            }
            case 8 : {
                this.setCardType(CardType.NINE);
                break;
            }
            case 9 : {
                this.setCardType(CardType.TEN);
                break;
            }
            case 10 : {
                this.setCardType(CardType.JACK);
                break;
            }
            case 11 : {
                this.setCardType(CardType.QUEEN);
                break;
            }
            case 12 : {
                this.setCardType(CardType.KING);
                break;
            }
            case 13 : {
                this.setCardType(CardType.ACE);
                break;
            }
        }

        maxValue = 4;
        range = maxValue - minValue + 1;
        randomize = random.nextInt(range)+ minValue;

        ////рандом условный масти карты
        switch (randomize){
            case 1 : {
                this.setCardSuite(CardSuit.CLUBS);
            }
            case 2 : {
                this.setCardSuite(CardSuit.DIAMONDS);
            }
            case 3 : {
                this.setCardSuite(CardSuit.HEARTS);
            }
            case 4 : {
                this.setCardSuite(CardSuit.SPADES);
            }
        }
    }

}
