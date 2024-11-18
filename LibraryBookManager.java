import java.util.Scanner;
import java.util.TreeMap;

class Book {
    String title;
    String author;
    int publicationYear;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Publication Year: " + publicationYear;
    }
}

public class LibraryBookManager {
    private TreeMap<String, Book> bookCollection;
    private Scanner scanner;

    public LibraryBookManager() {
        bookCollection = new TreeMap<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("Library Book Manager");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline left-over

            switch (option) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    displayBooks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    private void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        System.out.print("Enter book publication year: ");
        int publicationYear = scanner.nextInt();
        scanner.nextLine(); // consume newline left-over

        Book book = new Book(title, author, publicationYear);
        bookCollection.put(title, book);
        System.out.println("Book added successfully!");
    }

    private void removeBook() {
        System.out.print("Enter book title to remove: ");
        String title = scanner.nextLine();
        if (bookCollection.containsKey(title)) {
            bookCollection.remove(title);
            System.out.println("Book removed successfully!");
        } else {
            System.out.println("Book not found!");
        }
    }

    private void searchBook() {
        System.out.print("Enter book title or author to search: ");
        String query = scanner.nextLine();
        for (Book book : bookCollection.values()) {
            if (book.title.contains(query) || book.author.contains(query)) {
                System.out.println(book);
            }
        }
    }

    private void displayBooks() {
        if (bookCollection.isEmpty()) {
            System.out.println("No books in the library!");
        } else {
            for (Book book : bookCollection.values()) {
                System.out.println(book);
            }
        }
    }

    public static void main(String[] args) {
        LibraryBookManager manager = new LibraryBookManager();
        manager.run();
    }
}