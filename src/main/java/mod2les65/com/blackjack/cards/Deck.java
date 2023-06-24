package mod2les65.com.blackjack.cards;
//находится в пакете cards

import java.util.Random;

public class Deck {
    //содержит внутренний массив карт Card - внутреннее представление колоды
    private Card[] cardsDeck;
    //кол-во карт в колоде, добавил для метода шафл
    private int cardsInDeck;

    /*
    конструктор без параметров
        генерируется число от 1 до 8 - число стандартных колод из 52 карт,
        которые буду замешиваться в общую
        (стандартная колода из 52х карт содержит 13 типов карт по 4 масти)
        создается общая колода
        перетасовывается колода
     */
    public Deck() {
        //генерируется число от 1 до 8 - число стандартных колод из 52 карт,
        //которые буду замешиваться в общую
        int maxValue = 8;
        int minValue = 1;
        int range = maxValue - minValue + 1;
        Random random = new Random();

        int numOfSuits = random.nextInt(range) + minValue;
        cardsInDeck = numOfSuits * 52;

        //создается общая колода, пока без учета колод
        cardsDeck = new Card[cardsInDeck];
        for (int i = 0; i < cardsInDeck; i++) {
            cardsDeck[i] = new Card();
        }
        //перетасовывается колода
        shuffle();
    }

    /*
    внутренний метод shuffle
        случайным образом меняет порядок карт
     */
    private void shuffle() {
        int maxValue = cardsInDeck;
        int minValue = 2;
        int range = maxValue - minValue + 1;
        Random random = new Random();
        //сохраяем карту с верха, которую забрали
        Card temp = cardsDeck[0];
        //остальные карты смещаем
        for(int i = 0; i < cardsDeck.length - 1; i++){
            cardsDeck[i] = cardsDeck[i + 1];
        }
        //нулевую карту в конец колоды
        cardsDeck[cardsDeck.length - 1] = temp;

        //перемешивание соседних карт рандомное кол-во раз
        //под условие: случайным образом меняет порядок карт, надеюсь подходит
        for (int i = 0; i < random.nextInt(range) + minValue; i++) {
            int randPosition = random.nextInt(range) + minValue;
            temp = cardsDeck[randPosition - 1];
            cardsDeck[randPosition - 1] = cardsDeck[randPosition - 2];
            cardsDeck[randPosition - 2] = temp;
        }
    }

    /*
    общедоступный метод getTopCard
        перемешивает колоду
        возращает карту с верха колоды (с нулевым индексом)
     */
    public Card getTopCard() {
        shuffle();
        return cardsDeck[0];
    }

}
