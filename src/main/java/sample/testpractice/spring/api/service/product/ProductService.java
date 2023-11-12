package sample.testpractice.spring.api.service.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sample.testpractice.spring.api.controller.product.dto.request.ProductCreateRequest;
import sample.testpractice.spring.api.service.product.response.ProductResponse;
import sample.testpractice.spring.domain.product.Product;
import sample.testpractice.spring.domain.product.ProductRepository;
import sample.testpractice.spring.domain.product.ProductSellingStatus;
import sample.testpractice.spring.domain.product.ProductType;

import java.util.List;
import java.util.stream.Collectors;

/*
* readOnly = true : 읽기전용
* CRUD 에서 CUD 동작 X / only Read
* JPA : CUD 스냅샷 저장, 변경감지 X (성능 향상)
*
* CQRS - Command / Query
 */
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public ProductResponse createProduct(ProductCreateRequest request) {
        String nextProductNumber = createNextProductNumber();

        Product product = request.toEntity(nextProductNumber);
        Product savedProduct = productRepository.save(product);

        return ProductResponse.of(savedProduct);
    }

    @Transactional(readOnly = true)
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
