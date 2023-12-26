package com.api.productrestapi.service;

import com.api.productrestapi.model.Product;
import com.api.productrestapi.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImplement implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> read() {
        return productRepository.findAll();
    }

    @Override
    public Product update(Long id, Product product) {
        return productRepository.findById(id)
                .map(p -> {
                    p.setPrice(product.getPrice());
                    p.setDescription(product.getDescription());
                    p.setName(product.getName());
                    return productRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("product not found :( "));
    }

    @Override
    public String delete(Long id) {
        productRepository.deleteById(id);
        /*Product p = productRepository.findById(id).get();
        String s = p.getName();*/
        return "product deleted successfully";
//        return String.format("product %s deleted successfully", s);
    }
}
