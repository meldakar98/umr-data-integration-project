package utils.database_Info;

import java.util.List;

public class Table<T> {
    String name;
    List<String> attributes;

    public Table(String name, List<String> attributes, List<T> records, List<String> keys, List<String> forignKeys) {
        this.name = name;
        this.attributes = attributes;
        this.records = records;
        Keys = keys;
        this.forignKeys = forignKeys;
    }

    List<T> records;

    public String getName() {
        return name;
    }

    public List<String> getAttributes() {
        return attributes;
    }

    public List<T> getRecords() {
        return records;
    }
    public int getSize()
    {
        return records.size();
    }

    public List<String> getKeys() {
        return Keys;
    }

    public List<String> getForignKeys() {
        return forignKeys;
    }

    List<String> Keys;
    List<String> forignKeys;
}
