package it.apuliadigital.esercizioprovadbsqllite.repository;

import it.apuliadigital.esercizioprovadbsqllite.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
