package tests;

import api.apiCalls;
import enums.StatusCodes;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class GetTestsParameterized {

    @MethodSource("getCallParameters")
    @ParameterizedTest(name = "GET : {0} status code for get call to the end point with bast path - {1}")
    public void allGetCalls(int statusCode,String basePath)  {
        //To ensure tests are running on different threads
        System.out.println(" allGetCalls() start => " + Thread.currentThread().getName());
        Response response = new apiCalls().performGetCall(basePath);
        Assertions.assertEquals(statusCode,
                response.getStatusCode(),
                String.format("Status code is not %s", statusCode));
    }

    private static Stream<Arguments> getCallParameters() {
        return Stream.of(
                Arguments.of( StatusCodes.SUCCESS_CODE.getStatusCode(),"posts"),
                Arguments.of( StatusCodes.NOT_FOUND_CODE.getStatusCode(),"postsss"),
                Arguments.of( StatusCodes.SUCCESS_CODE.getStatusCode(),"posts/1"),
                Arguments.of( StatusCodes.NOT_FOUND_CODE.getStatusCode(),"posts/1000"),
                Arguments.of( StatusCodes.SUCCESS_CODE.getStatusCode(),"posts/1/comments"),
                Arguments.of( StatusCodes.SUCCESS_CODE.getStatusCode(),"comments?postId=1")
        );
    }
}
