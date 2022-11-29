package tests;

import api.apiCalls;
import enums.StatusCodes;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PatchTest {

    apiCalls apiCalls = new apiCalls();

    //To ensure tests are running on different threads a sout is used at the beginning of each test
    @DisplayName("PUT : 200 success code for POST request for valid json")
    @Test
    public void patchBodyWithValidJSON() {
        System.out.println(" patchWithValidJSON() start => " + Thread.currentThread().getName());
        String body = "Test Test Test";
        String requestBody = "{\n" +
                "  \"body\": \""+body+"\"\n}";
        Response response = apiCalls.performPatchCall(requestBody,"1");

        //We are asserting the status code and the if the response body contains the values that we passed
        Assertions.assertEquals(StatusCodes.SUCCESS_CODE.getStatusCode(), response.getStatusCode(), String.format("Status code is not %s", StatusCodes.SUCCESS_CODE));
        Assertions.assertEquals(body, response.jsonPath().getString("body"), "Body does not match the value sent.");
    }

    @DisplayName("PUT : 200 success code for POST request for valid json")
    @Test
    public void patchTitleWithValidJSON() {
        System.out.println(" patchWithValidJSON() start => " + Thread.currentThread().getName());
        String title = "Test";
        String requestBody = "{\n" +
                "  \"title\": \""+title+"\"\n}";
        Response response = apiCalls.performPatchCall(requestBody,"1");

        //We are asserting the status code and the if the response body contains the values that we passed
        Assertions.assertEquals(StatusCodes.SUCCESS_CODE.getStatusCode(), response.getStatusCode(), String.format("Status code is not %s", StatusCodes.SUCCESS_CODE));
        Assertions.assertEquals(title, response.jsonPath().getString("title"), "Title does not match the value sent.");
    }

    @DisplayName("PUT : 500 error code for POST request for invalid json")
    @Test
    public void patchWithInValidJSON() {
        System.out.println(" patchWithInvalidJSON() start => " + Thread.currentThread().getName());
        System.out.println(" patchWithValidJSON() start => " + Thread.currentThread().getName());
        String body = "Test Test Test";

        //Invalid json created with additional , at the end
        String requestBody = "{\n" +
                "  \"body\": \""+body+"\",,,\n}";
        Response response = apiCalls.performPatchCall(requestBody,"1");
        Assertions.assertEquals(StatusCodes.FAILURE_CODE.getStatusCode(), response.getStatusCode(), String.format("Status code is not %s", StatusCodes.FAILURE_CODE));
    }
}
