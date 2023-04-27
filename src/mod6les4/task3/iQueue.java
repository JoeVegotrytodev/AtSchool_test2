package mod6les4.task3;

public interface iQueue {
    void add(int value);
    int remove();
    boolean isEmpty();
    //Добавьте в интерфейс метод void sort(Swap method),
    // который принимает на вход интерфейс Swap.
    void sort(Swap method);
}
