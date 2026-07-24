import api.Post;
import api.PostApi;
import api.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

public class TestCreateOrders {

    private static final Random RANDOM = new Random();

    String firstName;
    String lastName;
    String address;
    Number metroStation; //тут непонятно, в доке String. В примере запроса - цифра. Ссылка на доку: https://qa-scooter.praktikum-services.ru/docs/
    String phone;
    Number rentTime;
    String deliveryDate;
    String comment;
    String[] color;

    PostApi postApi;

    @BeforeEach
    void setUp() {
        this.firstName = "firstName" + RANDOM.nextInt(10000);
        this.lastName = "lastName" + RANDOM.nextInt(10000);
        this.address = "address" + RANDOM.nextInt(10000);
        this.metroStation = RANDOM.nextInt(10);
        this.phone = "+7 800 355 35 35";
        this.rentTime = RANDOM.nextInt(100)+1;
        this.deliveryDate = "2020-06-06";
        this.comment = "comment"+RANDOM.nextInt(1000000);;
        this.postApi = new PostApi();
    }

    // 1. Метод-источник данных для теста
    static Stream<Arguments> provideColor() {
        return Stream.of(
                arguments("Выбран черный цвет", new String[]{"BLACK"}),
                arguments("Выбран серый цвет", new String[]{"GREY"}),
                arguments("Выбраны оба цвета", new String[]{"BLACK", "GREY"}),
                arguments("Не выбран цвет", new String[]{})
        );
    }

    @ParameterizedTest
    @MethodSource("provideColor")
    @DisplayName("Создание заказа с разными цветами")
    public void  createOrdersSuccess(String testName, String[] color){
        Post postToCreate = new Post(firstName, lastName, address,metroStation,phone,rentTime,deliveryDate,comment,color);
        Result actualPost = postApi.getPostOrders(postToCreate);

        assertThat(actualPost).isNotNull();
        assertThat(actualPost.getStatusCode()).isEqualTo(201);
        assertThat(actualPost.getPost().getTrack()).isNotNull();
    }

}
