import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Verwaltung {

    public void parseCsvFile(final String fileName) {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String current = null;
        try {
            current = reader.readLine();
            while (current != null) {
                processCsvLine(current);
                current = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void processCsvLine(String current) {
    }
/**
}
