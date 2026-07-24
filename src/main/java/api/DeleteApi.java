package api;

import io.restassured.response.Response;

public class DeleteApi extends BaseHttpClient{

    private static final String apiPathCourierDelete = "/api/v1/courier/";

    public Result deleteCourierById(Delete delete) {
        String path = apiPathCourierDelete + delete.getCourierId();
        Response response = doDeleteRequest(path, null);
        int statusCode = response.getStatusCode();
        return new Result(statusCode);
    }
}
