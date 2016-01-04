import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class BibliotecaViewTest {

    @Test
    public void shouldPrintWelcomeMessage() {
        OutputWriter outputWriter = Mockito.mock(OutputWriter.class);
        BibliotecaView bibliotecaView = new BibliotecaView("Welcome to Biblioteca !!", outputWriter);
        bibliotecaView.printWelcomeMessage();
        verify(outputWriter).println("Welcome to Biblioteca !!");
    }
}
