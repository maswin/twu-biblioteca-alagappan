import java.util.List;

public class Biblioteca {
    private String welcomeMessage;
    private List<String> books;

    public Biblioteca(String welcomeMessage, List<String> books) {
        this.welcomeMessage = welcomeMessage;
        this.books = books;
    }

    public void start(OutputWriter outputWriter) {
        printWelcomeMessage(outputWriter);
        displayAllBooks(outputWriter);
    }

    private void displayAllBooks(OutputWriter outputWriter) {
        outputWriter.println(books);
    }

    private void printWelcomeMessage(OutputWriter outputWriter) {
        outputWriter.println(welcomeMessage);
    }
}
