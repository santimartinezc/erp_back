package santimcxyz.erp.Transaction;

import java.sql.Date;

public class TransactionPeriodDTO {
    private Date date;
    private Double totalAmount;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public TransactionPeriodDTO() {
    }

    public TransactionPeriodDTO(Date date, Double totalAmount) {
        this.date = date;
        this.totalAmount = totalAmount;
    }

}
