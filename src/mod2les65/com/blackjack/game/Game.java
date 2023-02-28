package mod2les65.com.blackjack.game;
//находится в пакете game

import mod2les65.com.blackjack.cards.Card;
import mod2les65.com.blackjack.cards.Deck;
import mod2les65.com.blackjack.player.Player;

public class Game {
    //содержит внутреннее поле типа Deck - текущую игровую колоду
    Deck gameDeck;
    //содержит внутреннее поле типа Player - обозначает победиля игры
    Player player;
    //содержит внутреннее поле типа GameState - текущее состояние игры
    private GameState gameState;


    //содержит внутренний конструктор -
    // устанавливает начальное состояние игры STOP
    public Game() {
        gameState = GameState.STOP;
    }

    /*
        содержит внутренний метод isRunning - возвращает true,
        если состояние игры RUNNING
     */
    public boolean isRunning() {
        if (gameState == GameState.STOP)
            return true;
        else
            return false;
    }

    /*содержит внутренний метод start
        переводит игру в состояние RUNNING
        создает стартовую колоду
     */
    private void start() {
        gameState = GameState.RUNNING;
        gameDeck = new Deck();
    }

    /*содержит внутренний метод checkState
        по информации от двух игроков
        проверяет условия завершения игры, согласно описанию выше.
        Если устанавливается победа, то в поле победителя
        указывается соответствующий объект устанавливает состояние игры WIN
         Если устанавливается ничья, то устанавливает состояние игры DRAW
     */
    private GameState checkState(Player p1, Player p2) {
        if (!(p1.isActive() & p2.isActive())) {
            if (p1.getPoints() == p2.getPoints())
                return GameState.DRAW;
            else if (p1.getPoints() > p2.getPoints()) {
                player = p1;
                return GameState.WIN;
            } else if (p1.getPoints() < p2.getPoints()) {
                player = p2;
                return GameState.WIN;
            }
            else {
                return GameState.STOP;
            }
        }
        else return GameState.RUNNING;
    }

    /*содержит внутренний метод getTopCard
        достает из текущей колоды карту и возвращает ее
     */
    private Card getTopCard() {
        return gameDeck.getTopCard();
    }

    /*содержит внутренний метод takeTurn - совершает ход для указанного игрока
        игроку дают карту из колоды
        если игрок активен, то он берет карту
        выводят какую карту дали игроку
     */
    private void takeTurn(Player player, Card card) {
        if (player.isActive())
            player.takeCard(card);

        System.out.println(card);
    }

    /*содержит метод с доступом из пакета printResult
        выводит сообщение о результате игры в соответствии с ее состоянием
     */
    void printResult() {
        System.out.println("\n Current game state is " +
                gameState + "\n");
    }

    public static void main(String[] args) {
        //создается новая игра
        Game game = new Game();
        //создаются два игрока
        Player playerOne = new Player("Joe");
        Player playerTwo = new Player("Kim");
        //стартует новая игра
        game.start();

        //хотел использовать параметр класса player
        //но не стат параметр не может быть вызван из статик метода мейн
        //как правильно можно было сделать ?
        Player player = new Player("");
        /* повторяем пока игра продолжается
            по-очереди делаются ходы для каждого игрока
            проверяется завершена ли игра
        если игра завершена, то вывести информацию об игре
         */
        for(; ; ) {
            game.takeTurn(playerOne, game.getTopCard());
            game.takeTurn(playerTwo, game.getTopCard());

            game.printResult();

            game.gameState = game.checkState(playerOne, playerTwo);
            if (game.gameState != GameState.RUNNING) {
                    break;
            }
        }

        System.out.printf("\nGame over. Game status = %s.\nWinner - %s. " +
                        "%s - %d. %s - %d.", game.gameState, player,
                playerOne, playerOne.getPoints(), playerTwo, playerTwo.getPoints());
    }

}
