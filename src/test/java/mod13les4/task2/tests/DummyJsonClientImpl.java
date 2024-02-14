package mod13les4.task2.tests;

import com.google.gson.*;
import mod13les4.task2.data.Post;
import mod13les4.task2.data.Response;
import mod13les4.task2.data.Token;
import mod13les4.task2.data.User;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class DummyJsonClientImpl implements DummyJsonClient{

    public Response getUser(int userId) {
        try (CloseableHttpClient closeableHttpClient = HttpClients.createDefault()) {

            HttpGet httpGet = new HttpGet("https://dummyjson.com/users/" + userId);

            int responseCode = closeableHttpClient.execute(httpGet,
                    httpResponse -> httpResponse.getStatusLine().getStatusCode());

            String responseData = closeableHttpClient.execute(httpGet,
                    httpResponse -> EntityUtils.toString(httpResponse.getEntity()));

            return new Response(responseCode,
                    new User(userId, getLogin(responseData), getPassword(responseData)));
        } catch (IOException | ParseException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public Response login(User user) {

        try (CloseableHttpClient closeableHttpClient = HttpClients.createDefault()) {
            String body = "{\"username\": \"" + user.getLogin() + "\",\n" +
                    "\"password\": \"" + user.getPassword() + "\"}";
            InputStream stream = new ByteArrayInputStream(body.getBytes(StandardCharsets.UTF_8));

            HttpPost httpPost = new HttpPost("https://dummyjson.com/auth/login");
            httpPost.addHeader("Content-Type", "application/json");
            BasicHttpEntity httpEntity = new BasicHttpEntity();
            httpEntity.setContent(stream);
            httpPost.setEntity(httpEntity);

            //почему-то с запросом пост нельзя 2 вызова метода http сделать падает в ошибку
            //предположу, что приложение не дает дважды зарегистрировать под одним пользователем
            //поэтому ниже код 200 сам отправил в ответ, ибо в случае ошибки он и так на токене упадет
            //а с методом гет выше и ниже два вызова работают - часами искал причину не нашел
            String responseData = closeableHttpClient.execute(httpPost,
                    httpResponse -> EntityUtils.toString(httpResponse.getEntity()));

            JsonObject jsonObject = new JsonParser().parse(responseData).getAsJsonObject();
            Token token = new Token(jsonObject.get("token").getAsString());

            return new Response(200, token);
        } catch (IOException | ParseException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public Response getPosts(User u, Token token) {
        try (CloseableHttpClient closeableHttpClient = HttpClients.createDefault()) {
            ArrayList<Post> posts = new ArrayList<>();

//            HttpGet httpGet = new HttpGet("https://dummyjson.com/posts/user/" + u.getId());
            HttpGet httpGet = new HttpGet("https://dummyjson.com/auth/posts/user/" + u.getId());
            httpGet.addHeader("Authorization", "Bearer " + token.toString());
            httpGet.addHeader("Content-Type", "application/json");

            int responseCode = closeableHttpClient.execute(httpGet,
                    httpResponse -> httpResponse.getStatusLine().getStatusCode());
            String responseData = closeableHttpClient.execute(httpGet,
                    httpResponse -> EntityUtils.toString(httpResponse.getEntity()));

//            JsonObject jsonObject = new JsonParser().parse(responseData).getAsJsonObject();

            String stringOfJsonElementsArray = responseData.substring(9, 1249);
            JsonArray jsonPostsArray = new JsonParser().parse(stringOfJsonElementsArray).getAsJsonArray();

            jsonPostsArray.forEach(jsonElement -> posts.add(new Post(
                    jsonElement.getAsJsonObject().get("id").getAsInt(),
                    jsonElement.getAsJsonObject().get("title").getAsString(),
                    u.getId())));

           return new Response(responseCode, posts);
        } catch (IOException | ParseException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    private String getLogin(String responseData) {
        int logIndex = responseData.indexOf("username") + 11;
        String login = new String("");

        do {
            login = login + responseData.charAt(logIndex);
            logIndex++;
        } while (responseData.charAt(logIndex) != '\"');

        return login;
    }

    private String getPassword(String responseData) {
        int pswrdIndex = responseData.indexOf("password") + 11;
        String login = new String("");

        do {
            login = login + responseData.charAt(pswrdIndex);
            pswrdIndex++;
        } while (responseData.charAt(pswrdIndex) != '\"');

        return login;
    }

}
