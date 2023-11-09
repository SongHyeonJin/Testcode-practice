package sample.testpractice.spring.api.controller.product.dto.request;

import lombok.Getter;
import sample.testpractice.spring.domain.product.ProductSellingStatus;
import sample.testpractice.spring.domain.product.ProductType;

@Getter
public class ProductCreateRequest {

    private ProductType type;
    private ProductSellingStatus sellingStatus;
    private String name;
    private int price;

}
