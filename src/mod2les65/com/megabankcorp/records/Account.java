// это простой класс, который находится в пакете com.megabankcorp.records
package mod2les65.com.megabankcorp.records;

import java.math.BigDecimal;

public class Account {
    /*
    По тексту задания ниже совсем неочеивдно, что нужно добавить методы))
    Может стоит подправить задание ?

    Спроектируйте классы Account (счет) и Database (база данных) согласно описанию:
    Account
    это простой класс, который находится в пакете com.megabankcorp.records
    содержит
        поле для текущей суммы на счете
        поле для текущего номера счета
        поле для номера клиента банка

     */
    private BigDecimal currentSum;
    private long accountNumber;
    private long clientId;

    //получение номера счета
    public long getAccountNumber() {
        return accountNumber;
    }

    //Получение суммы средств
    public BigDecimal getCurrentSum() {
        return currentSum;
    }

    //сеттер суммы странно выглядит, лучше доабвление значения сделаю...
    public void addSum(BigDecimal sum){
        currentSum = currentSum.add(sum);
    }

    //получть ид клиента
    public long getClientId() {
        return clientId;
    }
}
