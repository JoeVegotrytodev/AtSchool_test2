package mod13les4.task2.data;

/***
 *  Token - токен, полученный при аунтификации; содержит
 *    *  строковое значение токена
 */
public class Token {
    private String token;

    public Token(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return token;
    }
}
