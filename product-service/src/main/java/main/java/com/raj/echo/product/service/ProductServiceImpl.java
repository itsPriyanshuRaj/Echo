package main.java.com.raj.echo.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.raj.echo.product.dto.ProductRequest;
import main.java.com.raj.echo.product.model.Product;
import main.java.com.raj.echo.product.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
    
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(ProductRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .quantity(request.getQuantity())
                .category(request.getCategory())
                .build();
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(String id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    @Override
    public Product updateProduct(String id, ProductRequest request) {
        Product existing = getProductById(id);
        existing.setName(request.getName());
        existing.setDescription(request.getDescription());
        existing.setPrice(request.getPrice());
        existing.setQuantity(request.getQuantity());
        existing.setCategory(request.getCategory());
        return productRepository.save(existing);
    }

    @Override
    public void deleteProduct(String id) {
        Product existing = getProductById(id);
        productRepository.delete(existing);
    }
}
