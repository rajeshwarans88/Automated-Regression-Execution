package tests;

import enums.StatusCodes;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import api.apiCalls;

public class GetTest {

    apiCalls apiCalls = new apiCalls();
    Response response;

    //To ensure tests are running on different threads a sout is used at the beginning of each test
    @DisplayName("GET : 200 success code for get call for all Posts when hitting correct end point")
    @Test
    public void getPostsSuccess() {
        System.out.println(" getPostsSuccess() start => " + Thread.currentThread().getName());
        response = apiCalls.performGetCall("posts");
        Assertions.assertEquals(StatusCodes.SUCCESS_CODE.getStatusCode(),
                response.getStatusCode(),
                String.format("Status code is not %s", StatusCodes.SUCCESS_CODE));
    }

    @DisplayName("GET : 404 error code for get call for all Posts when hitting incorrect end point")
    @Test
    public void getPostsFailure() {
        System.out.println(" getPostsFailure() start => " + Thread.currentThread().getName());
        response = apiCalls.performGetCall("postsss");
        Assertions.assertEquals(StatusCodes.NOT_FOUND_CODE.getStatusCode(),
                response.getStatusCode(),
                String.format("Status code is not %s", StatusCodes.NOT_FOUND_CODE));
    }

    @DisplayName("GET : 200 success code for get call for Posts with a valid id")
    @Test
    public void getPostsByIDSuccess() {
        System.out.println(" getPostsByIDSuccess() start => " + Thread.currentThread().getName());
        response = apiCalls.performGetCall("posts/1");
        Assertions.assertEquals(StatusCodes.SUCCESS_CODE.getStatusCode(),
                response.getStatusCode(),
                String.format("Status code is not %s", StatusCodes.SUCCESS_CODE));
    }

    @DisplayName("GET : 404 error code for get call for all Posts with an invalid id")
    @Test
    public void getPostsByIDFailure() {
        System.out.println(" getPostsByIDFailure() start => " + Thread.currentThread().getName());
        response = apiCalls.performGetCall("posts/1000");
        Assertions.assertEquals(StatusCodes.NOT_FOUND_CODE.getStatusCode(),
                response.getStatusCode(),
                String.format("Status code is not %s", StatusCodes.NOT_FOUND_CODE));
    }

    @DisplayName("GET : 200 success code for get call for comments of Posts with a valid id")
    @Test
    public void getCommentsByPostIDSuccess() {
        System.out.println(" getCommentsByPostIDSuccess() start => " + Thread.currentThread().getName());
        response = apiCalls.performGetCall("posts/1/comments");
        Assertions.assertEquals(StatusCodes.SUCCESS_CODE.getStatusCode(),
                response.getStatusCode(),
                String.format("Status code is not %s", StatusCodes.SUCCESS_CODE));
    }

    @DisplayName("GET : 200 success code for get call for comments with a valid post id")
    @Test
    public void getCommentsByUsingPostIDSuccess() {
        System.out.println(" getCommentsByUsingPostIDSuccess() start => " + Thread.currentThread().getName());
        response = apiCalls.performGetCall("comments?postId=1");
        Assertions.assertEquals(StatusCodes.SUCCESS_CODE.getStatusCode(),
                response.getStatusCode(),
                String.format("Status code is not %s", StatusCodes.SUCCESS_CODE));
    }
}
