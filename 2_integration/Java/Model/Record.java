package Model;

import java.util.List;

public interface Record {
    public String getCommaSeparatedString();
    public List<String> getValues();

    String get(String s);
}
