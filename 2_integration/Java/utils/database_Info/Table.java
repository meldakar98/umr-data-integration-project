package utils.database_Info;

import Model.Record;
import Model.SqlDatatypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Table<T> {
    String name;
    List<String> attributes;

    List<String> Keys;
    List<Map<String,Table<? extends Record>>> forignKeys;
    List<T> records;
    public Table(String name, List<String> attributes) {
        this.name = name;
        this.attributes = attributes;
        this.records = new ArrayList<>();

    }
    public void addRecord(T r)
    {
        records.add(r);
    }


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

    public List<Map<String, Table<? extends Record>>> getForignKeys() {
        return forignKeys;
    }

}
