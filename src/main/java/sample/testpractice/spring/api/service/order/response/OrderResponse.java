package sample.testpractice.spring.api.service.order.response;

import lombok.Getter;
import sample.testpractice.spring.api.service.product.response.ProductResponse;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class OrderResponse {

    private Long id;
    private int totalPrice;
    private LocalDateTime registeredDateTime;
    private List<ProductResponse> products;

}
