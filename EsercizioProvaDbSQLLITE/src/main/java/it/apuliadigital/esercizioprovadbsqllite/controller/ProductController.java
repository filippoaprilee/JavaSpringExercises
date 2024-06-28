package it.apuliadigital.esercizioprovadbsqllite.controller;

import it.apuliadigital.esercizioprovadbsqllite.model.Product;
import it.apuliadigital.esercizioprovadbsqllite.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/get")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product productUpdated = productOptional.get();
            productUpdated.setName(product.getName());
            productUpdated.setPrice(product.getPrice());
            return ResponseEntity.ok(productRepository.save(productUpdated));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.delete(product.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
