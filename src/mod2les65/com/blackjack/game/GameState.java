package mod2les65.com.blackjack.game;
//    находится в пакете game

public enum GameState {
    //игра остановлена, но не завершена. Начальное состояние игры
    STOP,
    //игра продолжается
    RUNNING,
    //игра закончилась победой одного из игроков
    WIN,
    //игра закончилась ничьей
    DRAW
}
