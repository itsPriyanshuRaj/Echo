package main.java.com.raj.echo.product.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import main.java.com.raj.echo.product.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
