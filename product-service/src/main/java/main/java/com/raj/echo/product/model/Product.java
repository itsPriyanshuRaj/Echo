package main.java.com.raj.echo.product.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document( collection ="Product")
public class Product {
    
    @Id
    private String id;

    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private String category;
}
