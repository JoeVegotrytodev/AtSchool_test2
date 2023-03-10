//находится в пакете com.megabankcorp.system
package mod2les65.com.megabankcorp.system;

import java.math.BigDecimal;
import mod2les65.com.megabankcorp.records.Account;

/*
Этот класс является абстрактным шаблоном для реализаций,
    которые будут создаваться в виде наследников этого класса.
    В нем находятся методы, которые наследники обязаны реализовать.
    Или реализации методов по-умолчанию.
    Вам наследников реализовывать не надо.
 */
public abstract class Database {
    /*
    - deposit - сохраняет указанную сумму на указанный счет
            не содержит реализации, просто сигнатура с описанием
            доступен отовсюду
     */
    public abstract void deposit(BigDecimal sum, Account account);

    /*
    - withdraw - забирает указанную сумму на указанный счет
            не содержит реализации, просто сигнатура с описанием
            доступен отовсюду
     */
    public abstract void withdraw(BigDecimal sum, Account account);

    /*
    - getAmount - получает значение суммы с указанного счета
            не содержит реализации, просто сигнатура с описанием
            доступен только из пакета и реализаций
     */
    protected abstract BigDecimal getAmount(Account account);

    /*
    - transfer - передает указанную сумму с одного указанного счета на другой
     содержит реализацию по умолчанию, использующую методы deposit и withdraw
            доступен только из пакета
     */
    void transfer(BigDecimal sum, Account accountIn, Account accountOut){
        withdraw(sum,accountOut);
        deposit(sum,accountIn);
    }
}
