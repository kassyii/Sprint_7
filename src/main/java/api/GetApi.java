package api;

import io.restassured.response.Response;

public class GetApi extends BaseHttpClient {

    private final String apiPathOrders = "/v1/orders";

    public Result getListOrders(Get getParams) {
        Response response = doOrdersListRequest(apiPathOrders, getParams);
        int statusCode = response.getStatusCode();
        OrdersResponse body = response.as(OrdersResponse.class);
        return new Result(statusCode, body);
    }
}
