package mod13les4.task2.tests;

import mod13les4.task2.data.Response;
import mod13les4.task2.data.Token;
import mod13les4.task2.data.User;

public interface DummyJsonClient {
    // dummyjson.com/users/{id}
    Response getUser(int id);

    // dummyjson.com/auth/login/
    Response login(User u);

    // dummyjson.com/auth/posts/{user.id}
    Response getPosts(User u, Token token);
}
