package utils;

import Model.Record;
import utils.database_Info.Table;

public interface DBWriter<T> {
    void write(Table<? extends Record> table);
}
