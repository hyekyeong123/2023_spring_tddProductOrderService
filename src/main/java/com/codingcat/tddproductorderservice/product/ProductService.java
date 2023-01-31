package com.codingcat.tddproductorderservice.product;

import org.springframework.stereotype.Component;

@Component
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
  public void addProduct(AddProductRequest request) {
    Product product = new Product(request.name(), request.price(), request.discountPolicy());
    productPort.save(product);
  }
}
