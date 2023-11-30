package santimcxyz.erp.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @JsonProperty("barCode")
    private Long barCode;
    @JsonProperty("productName")
    private String productName;
    @JsonProperty("quantity")
    private int quantity;
    @JsonProperty("taxes_pctg")
    private float taxes_pctg;
    @JsonProperty("price")
    private float price;

    public Product() {
    }

    public Product(Long barCode, String productName, int quantity, float taxes_pctg, float price) {
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

    public Long getBarCode() {
        return barCode;
    }

    public void setBarCode(Long barCode) {
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

    public void setTaxes_pctg(int taxes_pctg) {
        this.taxes_pctg = taxes_pctg;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
