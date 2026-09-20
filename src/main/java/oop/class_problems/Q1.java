import java.util.Scanner;
public class Q1 {
    public static void main(String[] args) {
        String[] titles = {"Clean Code", "Untitled Draft", "1984", "Notes"};
        String[] isbns = {"978-0132350884", "", "9780451524935", ""};
        LibraryBook[] books = new LibraryBook[titles.length];
        
        for (int i = 0; i < titles.length; i++) {
            if (isbns[i].equals("")) {
                books[i] = new LibraryBook(titles[i]);
            } else {
                books[i] = new LibraryBook(titles[i], isbns[i]);
            }
            System.out.println(books[i].title + " | " + books[i].isbn + " | Catalogued: true");
        }
    }
}
class LibraryBook {
    String title;
    String isbn;
    public LibraryBook(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }
    public LibraryBook(String title) {
        this(title, "PENDING");
    }
}
