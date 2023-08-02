package mod13les4.task2.tests;

import mod13les4.task2.data.Post;
import mod13les4.task2.data.Response;
import mod13les4.task2.data.Token;
import mod13les4.task2.data.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class EntryPoint134Tests {
    private static DummyJsonClientImpl dummyJsonClient;

    @BeforeEach
    public void setup(){
        dummyJsonClient = new DummyJsonClientImpl();
    }

    @Test
    public void getUserTest(){
        Response response = dummyJsonClient.getUser(1);
        Object responceObj = response.getResponceObj();
        User user = null;

        if (responceObj instanceof User)
            user = (User) responceObj;

        Assertions.assertEquals(200, response.getResponceCode());
        Assertions.assertEquals("atuny0", user.getLogin());
        Assertions.assertEquals("9uQFF1Lh", user.getPassword());
    }

    @Test
    public void loginTest(){
        Response responseLogin = null;
        Response responseGetUser = dummyJsonClient.getUser(1);
        Object responceObj = responseGetUser.getResponceObj();
        User user;

        if(responceObj instanceof User) {
            user = (User) responceObj;
            responseLogin = dummyJsonClient.login(new User(user.getId(), user.getLogin(), user.getPassword()));
        }

        Assertions.assertEquals(200, responseLogin.getResponceCode());
    }

    @Test
    public void postsTest(){
        Response responseGetUser = dummyJsonClient.getUser(1);
        Object responceObj = responseGetUser.getResponceObj();
        User user = null;

        Response responseToken = null;

        if(responceObj instanceof User) {
            user = (User) responceObj;
            responseToken = dummyJsonClient.login(new User(user.getId(), user.getLogin(), user.getPassword()));
        }

        Token token;
        Object tokenObj = responseToken.getResponceObj();
        Response responsePosts = null;
        if(tokenObj instanceof Token){
            token = (Token) tokenObj;
            responsePosts =  dummyJsonClient.getPosts(new User(user.getId(), user.getLogin(), user.getPassword()), token);
        }

        ArrayList<Post> posts = new ArrayList<>();
        Object postsObj = responsePosts.getResponceObj();
        if (postsObj instanceof ArrayList)
            posts = (ArrayList<Post>) postsObj;

        Assertions.assertEquals(200, responsePosts.getResponceCode());

        Assertions.assertEquals(10, posts.get(0).getId());
        Assertions.assertEquals("They rushed out the door.", posts.get(0).getTitle());
        Assertions.assertEquals(user.getId(), posts.get(0).getUserId());

        Assertions.assertEquals(14, posts.get(1).getId());
        Assertions.assertEquals("The paper was blank.", posts.get(1).getTitle());
        Assertions.assertEquals(user.getId(), posts.get(1).getUserId());

        Assertions.assertEquals(95, posts.get(2).getId());
        Assertions.assertEquals("So what is the answer? How can you stand", posts.get(2).getTitle());
        Assertions.assertEquals(user.getId(), posts.get(2).getUserId());
    }
}
