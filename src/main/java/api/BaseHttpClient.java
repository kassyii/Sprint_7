package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static api.Config.BASE_URL;
import static io.restassured.RestAssured.given;

public abstract class BaseHttpClient {

    public static RequestSpecification baseRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .addHeader("Content-Type", "application/json")
                .setRelaxedHTTPSValidation()
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new ErrorLoggingFilter())
                .build();
    }

    protected Response doPostRequest(String path, Object body) {
        return given()
                .spec(baseRequestSpec())
                .body(body)
                .post(path)
                .thenReturn();
    }

    protected Response doPostRequestWithResponse(String path, Object body) {
        return given()
                .spec(baseRequestSpec())
                .body(body)
                .post(path)
                .thenReturn();
    }

    protected Response doOrdersRequest(String path, Object body) {
        return given()
                .spec(baseRequestSpec())
                .body(body)
                .post(path)
                .thenReturn();
    }

    protected Response doOrdersListRequest(String path, Get getParams) {
        RequestSpecification request = given().spec(baseRequestSpec());

        if (getParams.getCourierId() != null) {
            request.queryParam("courierId", getParams.getCourierId());
        }
        if (getParams.getNearestStation() != null) {
            request.queryParam("nearestStation", getParams.getNearestStation());
        }
        if (getParams.getLimit() != null) {
            request.queryParam("limit", getParams.getLimit());
        }
        if (getParams.getPage() != null) {
            request.queryParam("page", getParams.getPage());
        }
        return request
                .get(path)
                .thenReturn();
    }

    protected Response doDeleteRequest(String path, Object body) {
        RequestSpecification request = given().spec(baseRequestSpec());

        if (body != null) {
            request.body(body);
        }
        return request
                .delete(path)
                .then()
                .extract()
                .response();
    }
}
