package api;

import io.restassured.response.Response;

public class PostApi extends BaseHttpClient {

    private final String apiPathCourierLogin = "/api/v1/courier/login/";

    private final String apiPathCourierCreate = "/api/v1/courier/";

    private final String apiPathOrders = "/api/v1/orders/";


    public Result getPostLoginWithStatus(Post post){
        Response response = doPostRequestWithResponse(apiPathCourierLogin, post);
        int statusCode = response.getStatusCode();
        Post body = response.as(Post.class);
        return new Result(statusCode, body);
    }

    public Result getPostCreateWithStatus(Post post) {
        Response response = doPostRequestWithResponse(apiPathCourierCreate, post);
        int statusCode = response.getStatusCode();
        Post body = response.as(Post.class);
        return new Result(statusCode, body);
    }

    public Result getPostOrders(Post post) {
        Response response = doOrdersRequest(apiPathOrders, post);
        int statusCode = response.getStatusCode();
        Post body = response.as(Post.class);
        return new Result(statusCode, body);
    }

}
