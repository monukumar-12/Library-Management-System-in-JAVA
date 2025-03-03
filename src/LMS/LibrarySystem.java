package LMS;

import java.util.*;

class Book{
    String title;
    Book(String title){
        this.title= title ;
    }
    public String getTitle(){
        return title;
    }
}

public class LibrarySystem{

     private ArrayList<Book> books = new ArrayList<>();

     public void addBook(String title){
        books.add(new Book(title ));
         System.out.println(" Book added Successfully ");

     }

     public void removeBook(String title){

             for (Book book : books) {
                 if (book.getTitle().equalsIgnoreCase(title)) {
                     books.remove(book);
                     System.out.println("Book removed successfully!");
                     return;
                 }
             }
             System.out.println("Book not found!");

     }

    public void searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not found!");
    }

    // Method to display all books in the library
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("Books available in the library:");
            for (Book book : books) {
                System.out.println("- " + book.getTitle());
            }
        }
    }

    // Method to show the total number of books
    public void showTotalBooks() {
        System.out.println("Total books available: " + books.size());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibrarySystem library = new LibrarySystem(); // Create an instance of LibrarySystem

        while (true) {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display Books");
            System.out.println("5. Show Total Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String addTitle = scanner.nextLine();
                    library.addBook(addTitle); // Call instance method
                    break;
                case 2:
                    System.out.print("Enter book title to remove: ");
                    String removeTitle = scanner.nextLine();
                    library.removeBook(removeTitle); // Call instance method
                    break;
                case 3:
                    System.out.print("Enter book title to search: ");
                    String searchTitle = scanner.nextLine();
                    library.searchBook(searchTitle); // Call instance method
                    break;
                case 4:
                    library.displayBooks(); // Call instance method
                    break;
                case 5:
                    library.showTotalBooks(); // Call instance method
                    break;
                case 6:
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }
}
