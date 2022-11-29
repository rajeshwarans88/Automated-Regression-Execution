package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class apiCalls {

    static String endPoint = "https://jsonplaceholder.typicode.com/";

    //Instead of using separate functions for different GET calls, the base path has been parameterized to avoid redundant functions
    @Step("Perform GET call with the provided base path - {0}")
    public Response performGetCall(String basePath){
        return given()
                .when()
                .get(endPoint+basePath)
                .then()
                .extract().response();
    }

    //Performing POST call for both valid and invalid json
    @Step("Perform POST call with the provided request body")
    public Response performPostCall(String body){
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(body)
                .when()
                .post(endPoint+"posts")
                .then()
                .extract().response();
    }

    //Performing PUT call for both valid and invalid json
    @Step("Perform PUT call with the provided request body")
    public Response performPutCall(String body,String postID){
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(body)
                .when()
                .put(endPoint+"posts/"+postID)
                .then()
                .extract().response();
    }

    //Performing PATCH call for both valid and invalid json
    @Step("Perform PATCH call with the provided request body")
    public Response performPatchCall(String body,String postID){
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(body)
                .when()
                .patch(endPoint+"posts/"+postID)
                .then()
                .extract().response();
    }

    //Performing DELETE call
    @Step("Perform DELETE call")
    public Response performDeleteCall(String postID){
        return given()
                .when()
                .delete(endPoint+"posts/"+postID)
                .then()
                .extract().response();
    }
}
