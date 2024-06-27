package it.apuliadigital.esercizioprovadb.repository;

import it.apuliadigital.esercizioprovadb.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
