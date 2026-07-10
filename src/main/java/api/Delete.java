package api;

public class Delete {

    private String id;

    public Delete (String id){
        this.id = id;
    }

    public String getCourierId() {
        return id;
    }

    public void setCourierId(String id) {
        this.id = id;
    }
}
