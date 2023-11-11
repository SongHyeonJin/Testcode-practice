package sample.testpractice.spring.api.service.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sample.testpractice.spring.api.controller.product.dto.request.ProductCreateRequest;
import sample.testpractice.spring.api.service.product.response.ProductResponse;
import sample.testpractice.spring.domain.product.Product;
import sample.testpractice.spring.domain.product.ProductRepository;
import sample.testpractice.spring.domain.product.ProductSellingStatus;
import sample.testpractice.spring.domain.product.ProductType;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductCreateRequest request) {
        String nexttProductNumber = createNextProductNumber();

        return ProductResponse.builder()
                .productNumber(nexttProductNumber)
                .type(request.getType())
                .sellingStatus(request.getSellingStatus())
                .name(request.getName())
                .price(request.getPrice())
                .build();
    }

    public List<ProductResponse> getSellingProducts(){
        List<Product> products = productRepository.findAllBySellingStatusIn(ProductSellingStatus.forDisplay());

        return products.stream()
                .map(ProductResponse::of)
                .collect(Collectors.toList());
    }

    private String createNextProductNumber(){
        String lastestProductNumber = productRepository.findLatestProductNumber();
        if(lastestProductNumber == null){
            return "001";
        }

        int lastsProductNumberInt = Integer.parseInt(lastestProductNumber);
        int nextProductNumberInt = lastsProductNumberInt + 1;

        // 9 -> 009 10 -> 010
        return String.format("%03d", nextProductNumberInt);
     }
}
