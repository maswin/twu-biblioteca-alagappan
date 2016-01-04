import java.io.OutputStream;
import java.io.PrintWriter;

public class OutputWriter {
    private final PrintWriter printWriter;

    public OutputWriter(OutputStream out) {
        printWriter = new PrintWriter(out);
    }

    public void println(String output) {
        printWriter.println(output);
        printWriter.flush();
    }
}
