package com.codingcat.tddproductorderservice.product;

import org.springframework.util.Assert;

class Product {

  private String name;
  private int price;
  private DiscountPolicy discountPolicy;
  private Long id;

  public Product(String name, int price, DiscountPolicy discountPolicy) {
    // 유효성 검사
    Assert.hasText(name, "상품명은 필수입니다.");
    Assert.isTrue(price > 0, "상품 가격은 0보다 커야합니다.");
    Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");

    this.name = name;
    this.price = price;
    this.discountPolicy = discountPolicy;
  }

  public void assignId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }
}
