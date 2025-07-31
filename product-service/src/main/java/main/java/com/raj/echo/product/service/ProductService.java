package main.java.com.raj.echo.product.service;

import java.util.List;

import main.java.com.raj.echo.product.dto.ProductRequest;
import main.java.com.raj.echo.product.model.Product;

public interface ProductService {
    Product createProduct(ProductRequest request);
    List<Product> getAllProducts();
    Product getProductById(String id);
    Product updateProduct(String id, ProductRequest request);
    void deleteProduct(String id);
}
