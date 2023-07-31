package mod13les4.task1;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class RestAssuredRequests {

    public void getWithParams() {
        String p1 = "v1", p2 = "v2";

        given()
                    .param("p1", "v1")
                    .param("p2", "v2")
                .when()
                    .get("https://httpbin.org/anything")
                .then()
                    .assertThat()
                    .statusCode(200)
                    .body("args.p1", equalTo(p1))
                    .body("args.p2", equalTo(p2));
    }

    /**
     *  Напишите тест, в которм отправляется запрос
     *    POST на httpbin.org/anything с телом запроса:
     *    {
     *      "parameter": "value"
     *    }
     *    Проверяется, что вернулся ответ с кодом 200,
     *    а в ответном json'е объект "json" с переданным в теле параметром.
     */
    public void postQuery(){

        given()
                    .contentType(ContentType.JSON)
                    .body("{\"parameter\": \"value\"}")
                .when()
                    .post("https://httpbin.org/anything")
                .then()
                    .assertThat()
                    .statusCode(200)
                    .body("json.parameter", equalTo("value"));
    }

    public void getReqWithAuth(){

        given()
                .auth()
                .preemptive()
                .basic("user", "password")
        .when()
                .get("https://httpbin.org/basic-auth/user/password")
        .then()
                .assertThat()
                .statusCode(200);
    }

    public void authReqWithBearerToken(){

//        given()
//                .header("Authorization", "Bearer " + "123")
//        .when()
//                .get("https://httpbin.org/bearer")
//        .then()
//                .assertThat()
//                .statusCode(200);

        given()
                .auth()
                .oauth2("Bearer 123")
        .when()
                .get("https://httpbin.org/bearer")
        .then()
                .assertThat()
                .statusCode(200);
    }
}
