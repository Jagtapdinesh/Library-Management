import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean available;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                books.remove(book);
                break;
            }
        }
    }

    public Book findBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    public List<Book> DisplayAllBooks() {
        return books;
    }
}

public class LibraryManagementSystem {
    private static Library library;
    private static Scanner scanner;

    public static void main(String[] args) {
        library = new Library();
        scanner = new Scanner(System.in);

        boolean quit = false;
        int choice;

        while (!quit) {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear the input buffer

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    findBook();
                    break;
                case 4:
                    DisplayAllBooks();
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n----- Library Management System Menu -----");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Find Book");
        System.out.println("4. Display All Books");
        System.out.println("5. Quit");
    }

    private static void addBook() {
        System.out.print("Enter book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Clear the input buffer

        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter book author: ");
        String author = scanner.nextLine();

        Book book = new Book(bookId, title, author);
        library.addBook(book);
        System.out.println("Book added successfully.");
    }

    private static void removeBook() {
        System.out.print("Enter book ID to remove: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Clear the input buffer

        library.removeBook(bookId);
        System.out.println("Book removed successfully.");
    }

    private static void findBook() {
        System.out.print("Enter book ID to find: ");
        int bookId = scanner.nextInt();
      scanner.nextLine();// Clear the input buffer
     Book bookid = library.findBook(bookId);
     System.out.println("finding book successfully");
        }
    private static void DisplayAllBooks()
    {
        System.out.println("Displaying all books");
        library.displayallbooks();
        
    }  
  }
