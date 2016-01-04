import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

public class BibliotecaTest {

    @Test
    public void shouldDisplayWelcomeMessageWhenApplicationIsStarted() {
        BibliotecaView bibliotecaView = Mockito.mock(BibliotecaView.class);
        Biblioteca biblioteca = new Biblioteca(new ArrayList<Book>(), bibliotecaView);
        biblioteca.start();
        verify(bibliotecaView).printWelcomeMessage();
    }

    @Test
    public void shouldDisplayListOfBooksAfterWelcomeMessage() {
        BibliotecaView bibliotecaView = Mockito.mock(BibliotecaView.class);
        List<Book> books = new ArrayList<>();
        Biblioteca biblioteca = new Biblioteca(books, bibliotecaView);
        biblioteca.start();
        verify(bibliotecaView).displayBooks(books);
    }
}
