package mod13les4.task2.data;

/***
 * -  User - класс пользователя; содержит как минимум следующие поля:
 *    *  id
 *    *  логин
 *    *  пароль
 */
public class User {
    private int id;

    private String login;

    private String password;

    public int getId() {
        return id;
    }

    public User(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object obj) {
        User anotherUser = null;

        if(obj instanceof User)
            anotherUser = (User) obj;


        return id == anotherUser.getId() &
                login.equals(anotherUser.getLogin()) &
                password.equals(anotherUser.password);
    }
}
