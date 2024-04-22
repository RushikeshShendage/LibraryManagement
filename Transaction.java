import java.time.LocalDate;
import java.util.ArrayList;


public class Transaction {
    private  static ArrayList<TransactionRecord>transactions=new ArrayList<>();
    public static void recordBorrowTransaction(String memberId,String bookId){
        transactions.add(new TransactionRecord(memberId,bookId,"book", LocalDate.now()));
        System.out.println("Borrow transaction recorded");
    }
    public static void recordReturnTransaction(String memberId,String bookTitle){
        transactions.add(new TransactionRecord(memberId,bookTitle,"Return",LocalDate.now()));
        System.out.println("Return transaction");
    }
    public static ArrayList<TransactionRecord>displayTransaction(){
        return transactions;
    }
}
