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
    List<String> Keys;
    List<String> forignKeys;
}
