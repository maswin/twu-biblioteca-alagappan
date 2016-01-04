import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

public class BibliotecaTest {

    @Test
    public void shouldDisplayWelcomeMessageWhenApplicationIsStarted() {
        Biblioteca biblioteca = new Biblioteca("Welcome to Biblioteca !!", new ArrayList<String>());
        OutputWriter outputWriter = Mockito.mock(OutputWriter.class);
        biblioteca.start(outputWriter);
        verify(outputWriter).println("Welcome to Biblioteca !!");
    }

    @Test
    public void shouldDisplayListOfBooksAfterWelcomeMessage() {
        List<String> books = new ArrayList<>();
        books.add("abc");
        books.add("def");
        Biblioteca biblioteca = new Biblioteca("Welcome to Biblioteca !!", books);
        OutputWriter outputWriter = Mockito.mock(OutputWriter.class);
        biblioteca.start(outputWriter);
        verify(outputWriter).println(books);
    }
}
