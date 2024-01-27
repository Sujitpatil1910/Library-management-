import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private String title;
    private boolean issued;

    public Book(String title) 
    {
        this.title = title;
        this.issued = false;
    }

    public String getTitle()
    {
        return title;
    }

    public boolean isIssued() 
    {
        return issued;
    }

    public void setIssued(boolean issued) 
    {
        this.issued = issued;
    }
}

class Library {
    private List<Book> books;

    public Library() 
    {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) 
    {
        books.add(book);
    }

    public void issueBook(String title) 
    {
        for (Book book : books) 
        {
            if (book.getTitle().equals(title) && !book.isIssued()) 
            {
                book.setIssued(true);
                System.out.println("You have successfully issued the book: " + book.getTitle());
                return;
            }
        }
        System.out.println("Sorry, the book '" + title + "' is not available.");
    }

    public void returnBook(String title) 
    {
        for (Book book : books) 
        {
            if (book.getTitle().equals(title) && book.isIssued()) 
            {
                book.setIssued(false);
                System.out.println("You have successfully returned the book: " + book.getTitle());
                return;
            }
        }
        System.out.println("Sorry, the book '" + title + "' is not valid for return or has not been issued.");
    }
}

public class LibraryManagementSystem 
{
    public static void main(String[] args) 
    {
        Library library = new Library();
        Book book1 = new Book("Book 1");
        Book book2 = new Book("Book 2");
        Book book3 = new Book("Book 3");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        Scanner scanner = new Scanner(System.in);
        while (true) 
        {
            System.out.println("1. Issue book from Library");
            System.out.println("2. Return book to Library");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character after reading the choice

            switch (choice) 
            {
                case 1:
                    System.out.print("Enter the title of the book to issue: ");
                    String issueTitle = scanner.nextLine();
                    library.issueBook(issueTitle);
                    break;
                case 2:
                    System.out.print("Enter the title of the book to return: ");
                    String returnTitle = scanner.nextLine();
                    library.returnBook(returnTitle);
                    break;
                case 3:
                    System.out.println("Thank you for using the Library Management System.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
