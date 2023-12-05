package santimcxyz.erp.Transaction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @JsonProperty("createdAt")
    private LocalDateTime createdAt = LocalDateTime.now();

    @NotNull(message = "vendorId cannot be null")
    @JsonProperty("vendorId")
    private Long vendorId;

    @NotNull(message = "totalAmount cannot be empty")
    @JsonProperty("totalAmount")
    private Float totalAmount;

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Transaction() {
    }

    public Transaction(@NotNull(message = "vendorId cannot be null") Long vendorId,
            @NotNull(message = "totalAmount cannot be empty") Float totalAmount) {
        this.vendorId = vendorId;
        this.totalAmount = totalAmount;
    }

}
