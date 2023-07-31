package mod13les4.task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RunTests{
    RestAssuredRequests restAssuredRequests;

    @BeforeEach
    void init(){
        restAssuredRequests = new RestAssuredRequests();
    }

    @Test
    public void getWithParamsTest(){
        restAssuredRequests.getWithParams();
    }

    @Test
    public void postWithBodyTest(){
        restAssuredRequests.postQuery();
    }

    @Test
    public void getWithAuthTest(){
        restAssuredRequests.getReqWithAuth();
    }

    @Test
    public void bearerAuthTest(){
        restAssuredRequests.authReqWithBearerToken();
    }
}
