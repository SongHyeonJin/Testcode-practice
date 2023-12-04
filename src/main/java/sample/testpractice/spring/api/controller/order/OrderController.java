package sample.testpractice.spring.api.controller.order;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sample.testpractice.spring.api.ApiResponse;
import sample.testpractice.spring.api.controller.order.request.OrderCreateRequest;
import sample.testpractice.spring.api.service.order.OrderSerivce;
import sample.testpractice.spring.api.service.order.response.OrderResponse;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderSerivce orderSerivce;

    @PostMapping("/api/v1/orders/new")
    public ApiResponse<OrderResponse> createOrder(@Valid @RequestBody OrderCreateRequest request){
        LocalDateTime registerdDateTime = LocalDateTime.now();
        return ApiResponse.ok(orderSerivce.createOrder(request.toServiceReqeust(), registerdDateTime));
    }


}
