package utils.JavaDataManager;

import Model.Record;
import Model.SqlDatatypes;
import utils.Database.database_Info.Table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AttributeMatchingVarchar {
    public static List<AttributeMatchingObject> getAttributeMatchingVarcharOnTables(List<Table<? extends Record>> tablesToCompare){
        HashMap<Table<? extends Record>,List<String>> tableAttr = new HashMap<>();
        List<AttributeMatchingObject> result = new ArrayList<>();
        for(Table<? extends Record> t : tablesToCompare){
            List<String> tAttributes = t.getAttributes();
            List<SqlDatatypes> tSqlDatatypes = new ArrayList<>();
            List<String> tAttrResult = new ArrayList<>();
            for (String attr : tAttributes){
               tSqlDatatypes.add(t.getRecords().get(0).getSqlDatatypes(attr));
            }
            for(int i = 0; i < tSqlDatatypes.size(); i++){
                if(tSqlDatatypes.get(i).getJavaDatentyp().equals(String.class)) tAttrResult.add(tAttributes.get(i));
            }
            tableAttr.put(t,tAttrResult);
        }

        tableAttr.forEach((table1, strings1) -> {
            tableAttr.forEach((table2, strings2) -> {

               strings1.forEach(attrToCompareTo -> {
                    getData(table1,attrToCompareTo).forEach(dataToCompareTo -> {
                        if(!table1.equals(table2)) strings2.forEach(attrToCompare -> result.addAll(getComparableStringsFrom(table2, attrToCompare, dataToCompareTo)));
                    } );

                });

            });
        });



        return result;

    }
    public static List<AttributeMatchingObject> getComparableStringsFrom(Table<? extends Record> table, String attributeFromTable, String compareBasis){
        return table.getRecords().stream().map(r -> r.get(attributeFromTable)).sorted().filter(s -> s.contains(compareBasis.substring(0,compareBasis.length()/2))).distinct().map(comp -> new AttributeMatchingObject(JaroWinkler.jaro_Winkler(compareBasis,comp),compareBasis,comp)).collect(Collectors.toList());

    }

    public static List<String> getData(Table<? extends Record> t,String attribute){
        return t.getRecords().stream().map(record -> record.get(attribute)).collect(Collectors.toList());
    }

}
