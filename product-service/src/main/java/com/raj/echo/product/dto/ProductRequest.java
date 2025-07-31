package main.java.com.raj.echo.product.dto;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ProductRequest {
    @NotBlank(message = "Product name is required")
    private String name;

    private String description;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private Double price;

    @NotNull(message = "Quantity is required")
    @Min(value = 0, message = "Quantity cannot be negative")
    private Integer quantity;

    private String category;
}
