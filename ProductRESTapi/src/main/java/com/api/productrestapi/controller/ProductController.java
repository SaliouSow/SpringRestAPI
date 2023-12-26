package com.api.productrestapi.controller;

import com.api.productrestapi.model.Product;
import com.api.productrestapi.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/create")
    public Product create(@RequestBody Product product){
        return productService.create(product);
    }

    @GetMapping("")
    public List<Product> read(){
        return productService.read();
    }

    @PutMapping("/update/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product){
        return productService.update(id, product);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return productService.delete(id);
    }
}
