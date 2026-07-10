import api.Get;
import api.GetApi;
import api.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;

public class TestOrderList {

    private GetApi getApi;

    @BeforeEach
    void setUp() {
        this.getApi = new GetApi();
    }

    @Test
    @DisplayName("Все активные/завершенные заказы курьера")
    public void getOrdersByCourierIdSuccess() {
        Get filter = new Get(1);
        Result result = getApi.getListOrders(filter);

        assertThat(result.getStatusCode()).isEqualTo(200);
        assertThat(result.getOrdersResponse()).isNotNull();
        assertThat(result.getOrdersResponse().getOrders()).isNotNull();
    }

    @Test
    @DisplayName("Все активные/завершенные заказы курьера на станциях \"Бульвар Рокоссовского\"(1) или \"Черкизовская\"(2)")
    public void getOrdersByCourierAndStationSuccess() {
        Get filter = new Get(1, "[\"1\", \"2\"]");
        Result result = getApi.getListOrders(filter);

        assertThat(result.getStatusCode()).isEqualTo(200);
        assertThat(result.getOrdersResponse()).isNotNull();
        assertThat(result.getOrdersResponse().getOrders()).isNotNull();
    }

    @Test
    @DisplayName("10 заказов, доступных для взятия курьером")
    public void getOrdersWithPaginationSuccess() {
        Get filter = new Get(10, 0);
        Result result = getApi.getListOrders(filter);

        assertThat(result.getStatusCode()).isEqualTo(200);
        assertThat(result.getOrdersResponse()).isNotNull();
        assertThat(result.getOrdersResponse().getOrders()).isNotNull();
    }

    @Test
    @DisplayName("10 заказов, доступных для взятия курьером возле метро \"Калужская\"(110)")
    public void getOrdersWithPaginationAndStationSuccess() {
        Get filter = new Get("[\"110\"]", 10, 0);
        Result result = getApi.getListOrders(filter);

        assertThat(result.getStatusCode()).isEqualTo(200);
        assertThat(result.getOrdersResponse()).isNotNull();
        assertThat(result.getOrdersResponse().getOrders()).isNotNull();
    }
}