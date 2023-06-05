package utils;

import Model.Record;
import utils.database_Info.Table;

public interface DBWriter<T> {
       void initWrite(Table<? extends Record> table, String databaseToWirteTo);
}
