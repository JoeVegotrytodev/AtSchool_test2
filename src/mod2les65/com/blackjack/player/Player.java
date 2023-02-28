package mod2les65.com.blackjack.player;
//находится в пакете player

import mod2les65.com.blackjack.cards.Card;
import mod2les65.com.blackjack.cards.CardHand;

import java.util.Random;

public class Player {
    //содержит внутренний параметр нервозности игрока - целое положительное число
    private int nervousRate;
    //содержит внутренний параметр состояния игрока PlayerState
    private PlayerState playerState;
    //содержит внутренний параметр CardHand -
    // текущая рука, которую игрок собрал на данный момент
    private CardHand cardHand;
    //содержит внутренний параметр имя игрока
    private String name;

    /*содержит конструктор, который принимает имя игрока в качестве параметра
        устанавливает имя игрока
        устанавливает параметр нервозности в 0
        устанавливает параметр состояния игрока в ACTIVE
        инициализирует руку игрока
     */
    public Player(String name) {
        this.name = name;
        nervousRate = 0;
        playerState = PlayerState.ACTIVE;
        cardHand = new CardHand();
    }

    /* содержит внутренний метод checkState проверяет состояние игрока -
    продолжает он или нет подсчитывает число очков в руке если "в руке"
    19, 20 или 21 очко, то состояние становится STOP, на этом проверка
    останавливается
    если "в руке" очков больше 10, то за каждое очко
    увеличивается параметр нервозности на 1 генериться случайное целое число
    от 0 до 10, 10 не включая если случайное число меньше текущей нервозности,
    то состояние игрока становится STOP
     */
    private void checkState(){
        int points = getPoints();
        Random random = new Random();

        if(points >= 19 & points <= 21) {
            System.out.println(this.name + " stopped...");
            playerState = PlayerState.STOP;
        }
        else if(points > 10){
            for(int j = 10; j <= points; j++) {
                nervousRate++;

                int maxValue = 10;
                int minValue = 1;
                int range = maxValue - minValue;
                int randNum = random.nextInt(range);

                if(randNum < nervousRate) {
                    playerState = PlayerState.STOP;
                    System.out.println(this.name + " nervous...");
                    break;
                }
            }
        }
    }

    /*
    содержит общедоступный метод isActive
        возвращает true, если текущее состояние игрока ACTIVE
     */
    public boolean isActive(){
        checkState();
        return playerState == PlayerState.ACTIVE;
    }

    /*
    содержит общедоступный метод takeCard -
        положить переданную карту в руку
        полученную карту добавляет в руку
        проверяет состояние игрока
     */
    public void takeCard(Card card){
       cardHand.addCard(card);
       checkState();
    }

    /*
     содержит общедоступный метод getPoints
        подсчитывает и возвращает кол-во очков "в руке"
     */
    public int getPoints(){
        return cardHand.getPoints();
    }

    /*
    содержит общедоступный метод toString
        возвращает имя игрока
     */
    @Override
    public String toString(){
        return name;
    }
}
