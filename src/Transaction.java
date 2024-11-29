import java.time.LocalDate;

public class Transaction {
    private String transactionType;
    private double amount;
    private LocalDate date;

    public Transaction(String transactionType, double amount) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.date = LocalDate.now();
    }

    public String getTransactionDetails() {
        return transactionType + " of $" + amount + " on " + date;
    }
}
