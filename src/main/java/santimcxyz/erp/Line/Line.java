package santimcxyz.erp.Line;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

@Entity
public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lineId;

    @NotNull(message = "transactionId cannot be null")
    @JsonProperty("transactionId")
    private Long transactionId;

    @NotNull(message = "productId cannot be null")
    @JsonProperty("productId")
    private Long productId;

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

    public Line() {
    }

    public Line(@NotNull(message = "productId cannot be null") Long productId,
            @NotNull(message = "transactionId cannot be empty") Long transactionId,
            @NotEmpty(message = "productName cannot be empty") String productName,
            @NotNull(message = "quantity cannot be null") int quantity,
            @NotNull(message = "taxes_pctg cannot be null") float taxes_pctg,
            @NotNull(message = "price cannot be null") float price) {
        this.productId = productId;
        this.transactionId = transactionId;
        this.productName = productName;
        this.quantity = quantity;
        this.taxes_pctg = taxes_pctg;
        this.price = price;
    }

    public Long getLineId() {
        return lineId;
    }

    public void setLineId(Long lineId) {
        this.lineId = lineId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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
