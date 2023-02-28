package mod2les65.com.blackjack.cards;
//находится в пакете cards

public class CardHand {
    //содержит внутренний массив карт Card - текущее состояние руки
    Card[] handStatus;

    /*
    содержит общедоступный конструктор без параметров
        инициализирует внутренний массив
     */
    public CardHand() {
        handStatus = new Card[0];
    }

    /*
    содержит общедоступный метод addCard
        добавляет карту "в руку"
     */
    public void addCard(Card newCard){
        //создаем новый массив с большим размером
        Card[] tempCardsList = new Card[handStatus.length + 1];
        //копируем туда старый массив
        for(int i = 0; i < handStatus.length; i++){
            tempCardsList[i] = handStatus[i];
        }
        //добавляем новую карты
        tempCardsList[tempCardsList.length - 1] = newCard;
        //возвращаем массив в "руку"
        handStatus = tempCardsList.clone();
    }

    /*
    содержит общедоступный метод getPoints
        возвращает количество очков "в руке"
     */
    public int getPoints(){
        int pointsSum = 0;
        //подсчет очков
        for(Card card : handStatus){
            pointsSum += card.getPoints();
        }
        return pointsSum;
    }
}
