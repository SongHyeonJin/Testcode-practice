package sample.testpractice.spring.api.controller.product.dto.request;

import lombok.Builder;
import lombok.Getter;
import sample.testpractice.spring.domain.product.ProductSellingStatus;
import sample.testpractice.spring.domain.product.ProductType;

@Getter
public class ProductCreateRequest {

    private ProductType type;
    private ProductSellingStatus sellingStatus;
    private String name;
    private int price;

    @Builder
    public ProductCreateRequest(ProductType type, ProductSellingStatus sellingStatus, String name, int price) {
        this.type = type;
        this.sellingStatus = sellingStatus;
        this.name = name;
        this.price = price;
    }

}
