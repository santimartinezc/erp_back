package santimcxyz.erp.Transaction;

import java.sql.Date;

public class TransactionYearDTO {
    private Date month;
    private Double totalAmount;

    public Date getDate() {
        return month;
    }

    public void setDate(Date month) {
        this.month = month;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public TransactionYearDTO() {
    }

    public TransactionYearDTO(Date month, Double totalAmount) {
        this.month = month;
        this.totalAmount = totalAmount;
    }

}
