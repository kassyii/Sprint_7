package api;

public class Get {
    Number courierId;
    String nearestStation;
    Number limit;
    Number page;

    public Get(Number courierId, String nearestStation, Number limit, Number page) {
        this.courierId = courierId;
        this.nearestStation = nearestStation;
        this.limit = limit;
        this.page = page;
    }

    public Get(Number courierId, String nearestStation, Number limit) {
        this.courierId = courierId;
        this.nearestStation = nearestStation;
        this.limit = limit;
    }

    public Get(Number courierId, String nearestStation) {
        this.courierId = courierId;
        this.nearestStation = nearestStation;
    }

    public Get(String nearestStation, Number limit) {
        this.nearestStation = nearestStation;
        this.limit = limit;
    }

    public Get(String nearestStation) {
        this.nearestStation = nearestStation;
    }

    public Get(Number courierId) {
        this.courierId = courierId;
    }

    public Get(String nearestStation, Number limit, Number page) {
        this.nearestStation = nearestStation;
        this.limit = limit;
        this.page = page;
    }

    public Get(Number limit, Number page) {
        this.limit = limit;
        this.page = page;
    }

    public Get(Number courierId, Number limit, Number page) {
        this.courierId = courierId;
        this.limit = limit;
        this.page = page;
    }

    public Number getCourierId() {
        return courierId;
    }

    public void setCourierId(Number courierId) {
        this.courierId = courierId;
    }

    public String getNearestStation() {
        return nearestStation;
    }

    public void setNearestStation(String nearestStation) {
        this.nearestStation = nearestStation;
    }

    public Number getLimit() {
        return limit;
    }

    public void setLimit(Number limit) {
        this.limit = limit;
    }

    public Number getPage() {
        return page;
    }

    public void setPage(Number page) {
        this.page = page;
    }
}
