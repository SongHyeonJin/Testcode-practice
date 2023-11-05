package sample.testpractice.spring.api.service.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sample.testpractice.spring.api.controller.order.request.OrderCreateRequest;
import sample.testpractice.spring.api.service.order.response.OrderResponse;
import sample.testpractice.spring.domain.order.Order;
import sample.testpractice.spring.domain.order.OrderRepository;
import sample.testpractice.spring.domain.product.Product;
import sample.testpractice.spring.domain.product.ProductRepository;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderSerivce {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderResponse createOrder(OrderCreateRequest request, LocalDateTime registeredDateTime) {
        List<String> productNumbers = request.getProductNumbers();
        List<Product> products = productRepository.findAllByProductNumberIn(productNumbers);

        // Order
        Order order = Order.create(products, registeredDateTime);
        Order saveOrder = orderRepository.save(order);
        return OrderResponse.of(saveOrder);
    }
}
