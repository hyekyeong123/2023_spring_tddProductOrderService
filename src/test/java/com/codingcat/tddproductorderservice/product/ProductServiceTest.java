package com.codingcat.tddproductorderservice.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceTest {

  @Autowired private ProductService productService;

  @Test
  void 상품등록(){
    AddProductRequest request = 상품등록요청_생성();
//    productService.addProduct(request);

    // API 요청
  }

  private static AddProductRequest 상품등록요청_생성(){
    final String name = "상품명";
    final int price = 1000;
    final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
    final AddProductRequest request = new AddProductRequest(name, price, discountPolicy);
    return request;
  }
}