package enums;

public enum StatusCodes {

    //Any additional status codes can be added here.
    //This is done to avoid hard coding of the values in the assertion in tests
    POST_SUCCESS(201),
    SUCCESS_CODE (200),
    FAILURE_CODE (500),
    NOT_FOUND_CODE (404);

    private final int statusCode;

    StatusCodes(int statusCode) { this.statusCode = statusCode; }

    public int getStatusCode() {
        return statusCode;
    }
}
