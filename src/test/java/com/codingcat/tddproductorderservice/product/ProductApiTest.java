package com.codingcat.tddproductorderservice.product;

import static org.assertj.core.api.Assertions.assertThat;

import com.codingcat.tddproductorderservice.ApiTest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

class ProductApiTest extends ApiTest {

  @Autowired private ProductService productService;

  @Test
  void 상품등록(){
    var request = 상품등록요청_전_생성();
    var response = 상품등록요청(request);
    assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value()); // 201
  }

  private static ExtractableResponse<Response> 상품등록요청(
    AddProductRequest request
  ) {
    return RestAssured.given().log().all()
      .contentType(MediaType.APPLICATION_JSON_VALUE)
      .body(request)

      .when()
      .post("/products")

      .then()
      .log().all().extract();
  }

  private static AddProductRequest 상품등록요청_전_생성(){
    final String name = "상품명";
    final Integer price = 1000;
    final DiscountPolicy discountPolicy = DiscountPolicy.NONE;

    final AddProductRequest request = new AddProductRequest(name, price, discountPolicy);
    return request;
  }
}