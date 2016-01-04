import java.util.List;

public class Biblioteca {
    private List<String> books;
    private BibliotecaView bibliotecaView;

    public Biblioteca(List<String> books, BibliotecaView bibliotecaView) {
        this.books = books;
        this.bibliotecaView = bibliotecaView;
    }

    public void start() {
        printWelcomeMessage();
        displayBooks();
    }

    private void displayBooks() {
        bibliotecaView.displayBooks(books);
    }

    private void printWelcomeMessage() {
        bibliotecaView.printWelcomeMessage();
    }
}
