import org.junit.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

public class BibliotecaViewTest {

    @Test
    public void shouldPrintWelcomeMessage() {
        OutputWriter outputWriter = Mockito.mock(OutputWriter.class);
        BibliotecaView bibliotecaView = new BibliotecaView("Welcome to Biblioteca !!", outputWriter);
        bibliotecaView.printWelcomeMessage();
        verify(outputWriter).println("Welcome to Biblioteca !!");
    }

    @Test
    public void shouldPrintListOfBooks() throws Exception {
        OutputWriter outputWriter = Mockito.mock(OutputWriter.class);
        BibliotecaView bibliotecaView = new BibliotecaView("Welcome to Biblioteca !!", outputWriter);
        List<Book> books = new ArrayList<>();
        Book book1 = Mockito.mock(Book.class);
        books.add(book1);
        Book book2 = Mockito.mock(Book.class);
        books.add(book2);
        bibliotecaView.displayBooks(books);
        verify(outputWriter).println(book1);
        verify(outputWriter).println(book2);
    }
}
