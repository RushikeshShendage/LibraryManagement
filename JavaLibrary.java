
import java.util.ArrayList;
import java.util.Scanner;

public class JavaLibrary {
    private final static String LIBRARY_NAME="JAVA LIBRARY";
    private static long num=5000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to library");
        Library library = new Library();
        boolean exit = true;
        while (exit) {
            System.out.println("Enter the Choice:  \n1AddBook: \n2AddMember: \n3Get Books: \n4Get Members: \n5Borrow Book: \n6Return Book: \n7Get Borrowed by Member: \n8Borrowed Transaction: \n9Return Transaction: \n10 Exit");
            int ch = sc.nextInt();
            switch (ch) {
                case 1: {
                    System.out.println("Enter Title: ");
                    String title = sc.next();
                    Book existingBook = library.searchBookByTitle(title);
                    if (existingBook == null) {
                        System.out.println("Enter Book author category: ");
                        library.addBook(new Book(title, sc.next(), sc.next()));
                        System.out.println("Book added");
                    } else {
                        System.out.println("Book Already Exist: ");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Enter Id: ");
                    String id = sc.next();
                    Member existingMember = library.getMemberById(id);
                    if (existingMember == null) {
                        System.out.println("Not found add new member");
                        System.out.println("Enter Name");
                        library.addMember(new Member(sc.next(), "Lib" + ++num));
                    } else {
                        System.out.println("Member Already exist");
                    }
                    break;
                }
                case 3: {
                    library.displayAllBooks();
                    break;
                }
                case 4: {
                    library.displayAllMembers();
                    break;
                }
                case 5: {
                    System.out.println("Enter member id,book title");
                    library.borrowBook(sc.next(), sc.next());
                    break;
                }
                case 6: {
                    System.out.println("Enter the Member Id,book title");
                    library.returnBook(sc.next(), sc.next());
                }
                case 7: {
                    System.out.println("Enter Id: ");
                    String id = sc.next();
                    Member existingMember = library.getMemberById(id);
                    ArrayList<Book> bookList = existingMember.getBorrowedBooks();
                    for (Book book : bookList) {
                        System.out.println(book);
                    }
                    break;
                }
                case 8: {
                    ArrayList<TransactionRecord> records = Transaction.displayTransaction();
                    for (TransactionRecord record : records) {
                        if (record.getTransactionType().equals("Borrow")) {
                            System.out.println(record);
                        }
                    }
                    break;
                }
                case 9: {
                    ArrayList<TransactionRecord> records = Transaction.displayTransaction();
                    for (TransactionRecord record : records) {
                        if (record.getTransactionType().equals("Return")) {
                            System.out.println(record);
                        }
                    }
                    break;
                }
                case 10: {
                    exit = false;
                    break;
                }
                default: {
                    System.out.println("Invalid choice,try again....");
                }
            }
        }
        System.out.println("Thank you");
        sc.close();
    }
    }

