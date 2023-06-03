package utils;

import utils.database_Info.Table;

public interface DBWriter<T> {
    void write(Table<T> table);
}
