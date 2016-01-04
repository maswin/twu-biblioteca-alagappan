public class Biblioteca {
    private String welcomeMessage;

    public Biblioteca(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public void start(OutputWriter outputWriter) {
        printWelcomeMessage(outputWriter);
    }

    private void printWelcomeMessage(OutputWriter outputWriter) {
        outputWriter.println(welcomeMessage);
    }
}
