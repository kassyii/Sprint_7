package api;

import java.util.List;


public class OrdersResponse {
    private List<Object> orders;


    public List<Object> getOrders() {
        return orders;
    }

    public void setOrders(List<Object> orders) {
        this.orders = orders;
    }
}