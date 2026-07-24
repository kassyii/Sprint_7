package api;

public class Post {

    private String login;
    private String password;
    private String firstNameCouriers;

    private String body;

    private String firstName;
    private String lastName;
    private String address;
    private Number metroStation;
    private String phone;
    private Number rentTime;
    private String deliveryDate;
    private String comment;
    private String[] color;

    private boolean ok;
    private String message;

    private String id;

    private Integer track;


    //конструктор для логина курьера
    public Post(String login, String password){
        this.login = login;
        this.password = password;
    }

    //конструктор для создания курьера
    public Post(String login, String password, String firstNameCouriers){
        this.login = login;
        this.password = password;
        this.firstNameCouriers = firstNameCouriers;
    }

    //конструктор для заказа без цвета
    public Post(String firstName, String lastName,String address,Number metroStation,String phone
                ,Number rentTime,String deliveryDate,String comment){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstNameCouriers() {
        return firstNameCouriers;
    }

    public void setFirstNameCouriers(String firstNameCouriers) {
        this.firstNameCouriers = firstNameCouriers;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Number getMetroStation() {
        return metroStation;
    }

    public void setMetroStation(Number metroStation) {
        this.metroStation = metroStation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Number getRentTime() {
        return rentTime;
    }

    public void setRentTime(Number rentTime) {
        this.rentTime = rentTime;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String[] getColor() {
        return color;
    }

    public void setColor(String[] color) {
        this.color = color;
    }

    public boolean getOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTrack() {
        return track;
    }

    public void setTrack(Integer track) {
        this.track = track;
    }

    //конструктор для заказа c цветом
    public Post(String firstName, String lastName,String address,Number metroStation,String phone
            ,Number rentTime,String deliveryDate,String comment,String[] color){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.color = color;
    }

}
