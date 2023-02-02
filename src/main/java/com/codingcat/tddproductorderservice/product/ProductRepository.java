package com.codingcat.tddproductorderservice.product;

import java.util.HashMap;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ProductRepository extends JpaRepository<Product, Long> {
//  private Map<Long, Product> persistence = new HashMap<>();
//  private Long sequence = 0L;
//
//  public void save(Product product) {
//    product.assignId(++sequence);
//    persistence.put(product.getId(), product);
//  }
}
