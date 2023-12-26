package com.api.productrestapi.service;

import com.api.productrestapi.model.Product;

import javax.sound.sampled.Port;
import java.util.List;

public interface ProductService {
    Product create(Product product);
    List<Product> read();
    Product update(Long id, Product product);
    String delete(Long id);
}
