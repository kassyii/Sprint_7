package api;

public class Result {
    private Get get;
    private int statusCode;
    private String message;
    private Post post;
    private Integer  track;
    private OrdersResponse ordersResponse;


    public Result(int statusCode, Post post) {
        this.statusCode = statusCode;
        this.post = post;
    }

    public Result(int statusCode) {
        this.statusCode = statusCode;
    }

    public Result(int statusCode, OrdersResponse ordersResponse) {
        this.statusCode = statusCode;
        this.ordersResponse = ordersResponse;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Post getPost() {
        return post;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getTrack() {
        return track;
    }

    public void setTrack(Integer track) {
        this.track = track;
    }

    public Get getGet() {
        return get;
    }

    public void setGet(Get get) {
        this.get = get;
    }

    public OrdersResponse getOrdersResponse() {
        return ordersResponse;
    }
}
