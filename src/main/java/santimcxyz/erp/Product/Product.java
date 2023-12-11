package santimcxyz.erp.Product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @NotNull(message = "barCode cannot be null")
    @Column(unique = true)
    @JsonProperty("barCode")
    private String barCode;

    @NotEmpty(message = "productName cannot be empty")
    @JsonProperty("productName")
    private String productName;

    @NotNull(message = "quantity cannot be null")
    @JsonProperty("quantity")
    private int quantity;

    @NotNull(message = "taxes_pctg cannot be null")
    @JsonProperty("taxes_pctg")
    private float taxes_pctg;

    @NotNull(message = "price cannot be null")
    @JsonProperty("price")
    private float price;

    public Product() {
    }

    public Product(@NotEmpty(message = "barCode cannot be null") String barCode,
            @NotEmpty(message = "productName cannot be empty") String productName,
            @NotNull(message = "quantity cannot be null") int quantity,
            @NotNull(message = "taxes_pctg cannot be null") float taxes_pctg,
            @NotNull(message = "price cannot be null") float price) {
        this.barCode = barCode;
        this.productName = productName;
        this.quantity = quantity;
        this.taxes_pctg = taxes_pctg;
        this.price = price;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTaxes_pctg() {
        return taxes_pctg;
    }

    public void setTaxes_pctg(float taxes_pctg) {
        this.taxes_pctg = taxes_pctg;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
