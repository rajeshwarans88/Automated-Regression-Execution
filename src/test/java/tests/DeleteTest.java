package tests;

import api.apiCalls;
import enums.StatusCodes;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeleteTest {

    apiCalls apiCalls = new apiCalls();

    @DisplayName("DELETE : 200 success code for DELETE request")
    @Test
    public void deleteCall() {
        //To ensure tests are running on different threads
        System.out.println(" deleteCall() start => " + Thread.currentThread().getName());
        Response response = apiCalls.performDeleteCall("1");

        //Since the request does not actually delete the entry, we are just verifying the status code
        Assertions.assertEquals(StatusCodes.SUCCESS_CODE.getStatusCode(),
                response.getStatusCode(),
                String.format("Status code is not %s", StatusCodes.SUCCESS_CODE));
    }
}
