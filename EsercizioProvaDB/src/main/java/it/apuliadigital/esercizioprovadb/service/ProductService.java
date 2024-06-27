package it.apuliadigital.esercizioprovadb.service;

import it.apuliadigital.esercizioprovadb.model.Product;
import it.apuliadigital.esercizioprovadb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product productdetails) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found for id: " + id));
        product.setName(productdetails.getName());
        product.setPrice(productdetails.getPrice());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
