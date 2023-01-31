package com.codingcat.tddproductorderservice.product;

import org.springframework.stereotype.Component;

@Component
class ProductAdapter implements ProductPort {

  private ProductRepository productRepository;

  ProductAdapter(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }


  @Override
  public void save(Product product) {
    productRepository.save(product);
  }
}
