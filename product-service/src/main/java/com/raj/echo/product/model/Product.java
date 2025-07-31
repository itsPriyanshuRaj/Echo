package main.java.com.raj.echo.product.model;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document( collections ="Product")
public class Product {
    
    @Id
    private String Id;
    private String name;
    private String price;
    private String descrption;
    private String quantity;
    private String category;
}
