import java.util.ArrayList;
import java.util.List;

// 1. The Book Class (Data Model)
class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "\"" + title + "\" by " + author;
    }
}

// 2. The Library Class (Management System)
class Library {
    // Declaring the ArrayList. It dynamically resizes!
    private List<Book> bookList;

    public Library() {
        // Initializing an empty ArrayList. No need to define a maximum size.
        this.bookList = new ArrayList<>();
    }

    // Add a new book
    public void addBook(Book book) {
        bookList.add(book); // ArrayList automatically grows to accommodate new items
        System.out.println("✅ Added: " + book.getTitle());
    }

    // Remove an issued book by title
    public void removeBook(String title) {
        boolean found = false;
        
        // Iterate through the list to find the book
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getTitle().equalsIgnoreCase(title)) {
                bookList.remove(i); // ArrayList automatically shifts elements to fill the gap
                System.out.println("🗑️ Removed (Issued): " + title);
                found = true;
                break; // Exit after removing the first match
            }
        }
        
        if (!found) {
            System.out.println("❌ Cannot remove: \"" + title + "\" not found in the library.");
        }
    }

    // Search for a book by title
    public void searchBook(String title) {
        System.out.println("\n🔍 Searching for: \"" + title + "\"...");
        for (Book book : bookList) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("✔️ Found: " + book.toString());
                return;
            }
        }
        System.out.println("❌ Book not found.");
    }

    // Display all available books
    public void displayBooks() {
        System.out.println("\n📚 Current Library Collection (" + bookList.size() + " books available):");
        if (bookList.isEmpty()) {
            System.out.println("The library is currently empty.");
        } else {
            for (int i = 0; i < bookList.size(); i++) {
                System.out.println((i + 1) + ". " + bookList.get(i).toString());
            }
        }
        System.out.println("------------------------------------------------");
    }
}

// 3. Main Class to run and test the system
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library myLibrary = new Library();

        System.out.println("--- Starting Library System ---");

        // Adding books (Demonstrating Dynamic Resizing)
        myLibrary.addBook(new Book("The Pragmatic Programmer", "David Thomas"));
        myLibrary.addBook(new Book("Clean Code", "Robert C. Martin"));
        myLibrary.addBook(new Book("Design Patterns", "Erich Gamma"));
        myLibrary.addBook(new Book("Head First Java", "Kathy Sierra"));

        // Displaying the collection
        myLibrary.displayBooks();

        // Searching for a book
        myLibrary.searchBook("clean code");
        myLibrary.searchBook("Effective Java"); // Won't be found

        // Removing a book (Simulating issuing a book)
        System.out.println("\n--- Issuing Books ---");
        myLibrary.removeBook("Design Patterns");
        myLibrary.removeBook("Unknown Book"); // Trying to remove a non-existent book

        // Displaying the collection again to show dynamic updates
        myLibrary.displayBooks();
    }
}
