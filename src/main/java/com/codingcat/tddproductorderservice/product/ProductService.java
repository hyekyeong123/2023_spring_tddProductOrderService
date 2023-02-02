package com.codingcat.tddproductorderservice.product;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/products")
public class ProductService {
  private ProductPort productPort;
  ProductService(ProductPort productPort){
    this.productPort = productPort;
  }

  /**
   * 상품 추가
   *
   * @param request
   */
  @PostMapping("/products")
  @Transactional
  public ResponseEntity<Void> addProduct(
    @RequestBody AddProductRequest request
  ) {
    Product product = new Product(request.name(), request.price(), request.discountPolicy());
    productPort.save(product);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
