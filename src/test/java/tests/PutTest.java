package tests;

import api.apiCalls;
import enums.StatusCodes;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PutTest {

    apiCalls apiCalls = new apiCalls();

    //To ensure tests are running on different threads a sout is used at the beginning of each test
    @DisplayName("PUT : 200 success code for POST request for valid json")
    @Test
    public void postWithValidJSON() {
        System.out.println(" putWithValidJSON() start => " + Thread.currentThread().getName());
        String userID = "1";
        String id = "1";
        String title = "Test";
        String body = "Test Test Test";
        String requestBody = "{\n" +
                "  \"title\": \""+title+"\",\n" +
                "  \"id\": \""+id+"\",\n" +
                "  \"body\": \""+body+"\",\n" +
                "  \"userId\": \""+userID+"\" \n}";
        Response response = apiCalls.performPutCall(requestBody,"1");

        //We are asserting the status code and the if the response body contains the values that we passed
        Assertions.assertEquals(StatusCodes.SUCCESS_CODE.getStatusCode(), response.getStatusCode(), String.format("Status code is not %s", StatusCodes.SUCCESS_CODE));
        Assertions.assertEquals(userID, response.jsonPath().getString("userId"), "User ID does not match the value sent");
        Assertions.assertEquals(id, response.jsonPath().getString("id"), "ID does not match the value sent");
        Assertions.assertEquals(title, response.jsonPath().getString("title"), "Title does not match the value sent");
        Assertions.assertEquals(body, response.jsonPath().getString("body"), "Body does not match the value sent.");
    }

    @DisplayName("PUT : 500 error code for POST request for invalid json")
    @Test
    public void postWithInValidJSON() {
        System.out.println(" putWithInvalidJSON() start => " + Thread.currentThread().getName());
        String userID = "1";
        String title = "Test";
        String body = "Test Test Test";
        String id = "1";

        //Invalid json created with additional , at the end
        String requestBody = "{\n" +
                "  \"title\": \""+title+"\",,\n" +
                "  \"id\": \""+id+"\",\n" +
                "  \"body\": \""+body+"\",,\n" +
                "  \"userId\": \""+userID+"\",,\n}";
        Response response = apiCalls.performPutCall(requestBody,"1");
        Assertions.assertEquals(StatusCodes.FAILURE_CODE.getStatusCode(), response.getStatusCode(), String.format("Status code is not %s", StatusCodes.FAILURE_CODE));
    }
}
