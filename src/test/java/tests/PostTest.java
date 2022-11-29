package tests;

import api.apiCalls;
import enums.StatusCodes;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PostTest {

    apiCalls apiCalls = new apiCalls();

    //To ensure tests are running on different threads a sout is used at the beginning of each test
    @DisplayName("POST : 201 success code for POST request for valid json")
    @Test
    public void putWithValidJSON() {
        System.out.println(" postWithValidJSON() start => " + Thread.currentThread().getName());
        String userID = "1";
        String title = "Test";
        String body = "Test Test Test";
        String requestBody = "{\n" +
                "  \"title\": \""+title+"\",\n" +
                "  \"body\": \""+body+"\",\n" +
                "  \"userId\": \""+userID+"\" \n}";
        Response response = apiCalls.performPostCall(requestBody);

        //We are asserting the status code and the if the response body contains the values that we passed
        Assertions.assertEquals(StatusCodes.POST_SUCCESS.getStatusCode(), response.getStatusCode(), String.format("Status code is not %s", StatusCodes.POST_SUCCESS));
        Assertions.assertEquals(userID, response.jsonPath().getString("userId"), "User ID does not match the value sent");
        Assertions.assertEquals(title, response.jsonPath().getString("title"), "Title does not match the value sent");
        Assertions.assertEquals(body, response.jsonPath().getString("body"), "Body does not match the value sent.");
    }

    @DisplayName("POST : 500 error code for POST request for invalid json")
    @Test
    public void putWithInValidJSON() {
        System.out.println(" postWithInvalidJSON() start => " + Thread.currentThread().getName());
        String userID = "1";
        String title = "Test";
        String body = "Test Test Test";

        //Invalid json created with additional , at the end
        String requestBody = "{\n" +
                "  \"title\": \""+title+"\",,\n" +
                "  \"body\": \""+body+"\",,\n" +
                "  \"userId\": \""+userID+"\",,\n}";
        Response response = apiCalls.performPostCall(requestBody);
        Assertions.assertEquals(StatusCodes.FAILURE_CODE.getStatusCode(), response.getStatusCode(), String.format("Status code is not %s", StatusCodes.FAILURE_CODE));
    }
}
