import java.time.LocalDate;

public class TransactionRecord {
    private String memberId;
    private String bookTitle;
    private String transactionType;
    private LocalDate transactionDate;
    public TransactionRecord() {

    }

    public TransactionRecord(String memberId, String bookTitle, String transactionType, LocalDate transactionDate) {
        super();
        this.memberId = memberId;
        this.bookTitle = bookTitle;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "TransactionRecord{" +
                "memberId='" + memberId + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
