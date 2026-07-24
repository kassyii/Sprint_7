import api.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class TestLoginCourier {

    private static final Random RANDOM = new Random();

    String login;
    String password;
    String firstNameCouriers;
    String courierId;
    PostApi postApi;
    DeleteApi deleteApi;

    @BeforeEach
    void setUp(){
        this.login = "unique_test_" + RANDOM.nextInt(10000);
        this.password = "strong_password_987654321";
        this.firstNameCouriers = "Leo" + RANDOM.nextInt(10000);
        this.postApi = new PostApi();
        this.deleteApi = new DeleteApi();

        //Создадим курьера
        Post postToCreate = new Post(login, password, firstNameCouriers);
        Result createCourier = postApi.getPostCreateWithStatus(postToCreate);

    }

    @AfterEach
    void tearDown() {
        // Удаляем курьера, если ID был получен
        if (courierId != null) {
            Delete deleteCourier = new Delete(courierId);
            deleteApi.deleteCourierById(deleteCourier);
        }
    }

    @Test
    @DisplayName("Авторизация курьера")
    public void loginCourierSuccess() {
        Post postToLogin = new Post(login,password);
        Result actualPost = postApi.getPostLoginWithStatus(postToLogin);

        assertThat(actualPost).isNotNull();
        assertThat(actualPost.getStatusCode()).isEqualTo(200);
        assertThat(actualPost.getPost().getId()).isNotNull();

        this.courierId = actualPost.getPost().getId();
    }

    @Test
    @DisplayName("Авторизация курьера без логина")
    public void loginCourierWithoutLogin() {
        Post postToLogin = new Post(null,password);
        Result actualPost = postApi.getPostLoginWithStatus(postToLogin);

        assertThat(actualPost).isNotNull();
        assertThat(actualPost.getStatusCode()).isEqualTo(400);
        assertThat(actualPost.getPost().getMessage()).isEqualTo("Недостаточно данных для входа");

        this.courierId = actualPost.getPost().getId();
    }

    @Test
    @DisplayName("Авторизация курьера без пароля")
    public void loginCourierWithoutPassword() {
        Post postToLogin = new Post(login,null);
        Result actualPost = postApi.getPostLoginWithStatus(postToLogin);

        assertThat(actualPost).isNotNull();
        assertThat(actualPost.getStatusCode()).isEqualTo(400);
        assertThat(actualPost.getPost().getMessage()).isEqualTo("Недостаточно данных для входа");

        this.courierId = actualPost.getPost().getId();
    }

    @Test
    @DisplayName("Авторизация не существующего курьера")
    public void loginUnknownCourier() {
        login = "_test_" + RANDOM.nextInt(10000);
        password =  "_test_" + RANDOM.nextInt(10000);
        Post postToLogin = new Post(login,password);
        Result actualPost = postApi.getPostLoginWithStatus(postToLogin);

        assertThat(actualPost).isNotNull();
        assertThat(actualPost.getStatusCode()).isEqualTo(404);
        assertThat(actualPost.getPost().getMessage()).isEqualTo("Учетная запись не найдена");

        this.courierId = actualPost.getPost().getId();
    }

}
