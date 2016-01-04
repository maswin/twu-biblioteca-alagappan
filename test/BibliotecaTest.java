import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class BibliotecaTest {

    @Test
    public void shouldDisplayWelcomeMessageWhenApplicationIsStarted() throws Exception {
        Biblioteca biblioteca = new Biblioteca("Welcome to Biblioteca !!");
        OutputWriter outputWriter = Mockito.mock(OutputWriter.class);
        biblioteca.start(outputWriter);
        verify(outputWriter).println("Welcome to Biblioteca !!");
    }


}
