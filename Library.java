import java.util.ArrayList;
import java.util.HashMap;
public class Library {
    private HashMap<String,Book>books;
    private  HashMap<String,Member>members;
    public Library(){
        this.books=new HashMap<>();
        this.members=new HashMap<>();
    }
    public void addBook(Book book){
        books.put(book.getTitle(),book);
    }
    public Book searchBookByTitle(String title){
        return books.get(title);
    }
    public void addMember(Member member){
        members.put(member.getMemberId(),member);
    }
    public void removeMember(String memberId){
        members.remove(memberId);
    }
    public Member getMemberById(String memberId){
        return members.get(memberId);
    }
    public void borrowBook(String memberId,String title){
        Member member = members.get(memberId);
        Book book=books.get(memberId);
        if (member != null && book != null){
            if (book.isAvailable()){
                book.setAvailability(false);
                member.setBorrowedBooks(book);
                System.out.println("Book: "+book.getTitle()+"has been borrowed"+member.getName());
                Transaction.recordBorrowTransaction(memberId,title);
            }else {
                System.out.println("Book: "+book.getTitle()+"is not avilable");
            }
        }else {
            System.out.println("Invalid memeber book id");
        }
    }
    public  void returnBook(String memberId,String title){
        Member member=members.get(memberId);
        Book book=books.get(title);

        if (member != null && book != null){
            if (member.getBorrowedBooks().contains(book)){
                book.setAvailability(true);
                member.returnBook(book);
                System.out.println("Book: "+book.getTitle()+"has been returned by: "+member.getName());
                Transaction.recordReturnTransaction(memberId,title);
            }else {
                System.out.println("Member: "+member.getName()+"has no borrowed"+book.getTitle());
            }
        }else {
            System.out.println("Invalid book id");
        }
    }
    public void displayAllBooks(){
        for (Book book:books.values()){
            System.out.println(book);
        }
    }
    public void displayAllMembers(){
        for (Member member:members.values()){
            System.out.println(member);
        }
    }
}
