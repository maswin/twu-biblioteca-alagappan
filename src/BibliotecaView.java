import java.util.List;

public class BibliotecaView {
    private final String welcomeMessage;
    private final OutputWriter outputWriter;

    public BibliotecaView(String welcomeMessage, OutputWriter outputWriter) {
        this.welcomeMessage = welcomeMessage;
        this.outputWriter = outputWriter;
    }

    public void printWelcomeMessage() {
        outputWriter.println(welcomeMessage);
    }

    public void displayBooks(List<String> books) {
        for(String book : books) {
            outputWriter.println(book);
        }
    }
}
