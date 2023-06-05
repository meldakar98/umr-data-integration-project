package utils;

import Model.Record;
import Model.SqlDatatypes;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class KeyFinderTest {

    @Test
    void isKey() {
        KeyFinder kf=new KeyFinder();
        List<String> candidate=new ArrayList<>();
        candidate.add("name");
        List<String> atributes=new ArrayList<>();

        atributes.add("name");
        atributes.add("age");
        atributes.add("height");
        Record record1= new Record(atributes, "M;19;190");
        Record record2= new Record(atributes,"A;19;190");
        Record record3= new Record(atributes,"M;19;190");
        List<Record> records=new ArrayList<>();
        records.add(record1);
        records.add(record2);
        records.add(record3);
        assertEquals(kf.isKey(candidate,records),false);

    }
}