import api.Post;
import api.PostApi;
import api.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;

import java.util.Random;


public class TestCreateCourier {

    private static final Random RANDOM = new Random();

    String login;
    String password;
    String firstNameCouriers;
    PostApi postApi;

    @BeforeEach
    void setUp(){
        this.login = "unique_test_" + RANDOM.nextInt(10000);
        this.password = "strong_password_987654321";
        this.firstNameCouriers = "Leo";
        this.postApi = new PostApi();
    }

    @Test
    @DisplayName("Создание курьера")
    public void  createCourierSuccess(){
        Post postToCreate = new Post(login, password, firstNameCouriers);
        Result actualPost = postApi.getPostCreateWithStatus(postToCreate);

        assertThat(actualPost).isNotNull();
        assertThat(actualPost.getStatusCode()).isEqualTo(201);
        assertThat(actualPost.getPost().getOk()).isTrue();
    }

    @Test
    @DisplayName("Создание курьера без логина")
    public void  createCourierWithoutLogin(){
        Post postToCreate = new Post(null,password,firstNameCouriers);
        Result actualPost = postApi.getPostCreateWithStatus(postToCreate);
        assertThat(actualPost.getStatusCode()).isEqualTo(400);
        assertThat(actualPost.getPost().getMessage()).isEqualTo("Недостаточно данных для создания учетной записи");
    }

    @Test
    @DisplayName("Создание курьера без пароля")
    public void  createCourierWithoutPassword(){
        Post postToCreate = new Post(login,null,firstNameCouriers);
        Result actualPost = postApi.getPostCreateWithStatus(postToCreate);
        assertThat(actualPost.getStatusCode()).isEqualTo(400);
        assertThat(actualPost.getPost().getMessage()).isEqualTo("Недостаточно данных для создания учетной записи");
    }


    @Test
    @DisplayName("Создание курьера без имени")
    public void  createCourierWithoutFirstName(){
        Post postToCreate = new Post(login,password,null);
        Result actualPost = postApi.getPostCreateWithStatus(postToCreate);
        assertThat(actualPost.getStatusCode()).isEqualTo(400);
        assertThat(actualPost.getPost().getMessage()).isEqualTo("Недостаточно данных для создания учетной записи");
    }

    @Test
    @DisplayName("Создание двух одинаковых курьеров")
    public void  createCourierWithExistingLogin(){
        Post postToCreate = new Post(login,password,firstNameCouriers);
        Result actualPost = postApi.getPostCreateWithStatus(postToCreate);
        assertThat(actualPost).isNotNull();

        Post postToCreateExistingLogin = new Post(login,password,firstNameCouriers);
        Result actualPostExistingLogin = postApi.getPostCreateWithStatus(postToCreateExistingLogin);
        assertThat(actualPostExistingLogin.getStatusCode()).isEqualTo(409);
        assertThat(actualPostExistingLogin.getPost().getMessage()).isEqualTo("Этот логин уже используется");
    }
}
