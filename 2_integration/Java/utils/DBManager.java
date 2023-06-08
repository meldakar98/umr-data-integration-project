package utils;

import Model.Record;
import Model.SqlDatatypes;
import utils.database_Info.Database_Settings;
import utils.database_Info.Table;

import java.sql.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DBManager {
    private static Connection conn;

    private static String schema;

    public void setup(Database_Settings custom_db_settings) {
        try {
            this.schema =  custom_db_settings.schema;
            this.conn =  DriverManager.getConnection("jdbc:mysql://"+custom_db_settings.ip+"/"+custom_db_settings.schema+"?" +
                            "user="+custom_db_settings.username+"&password=" + custom_db_settings.password);

            // Do something with the Connection


        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }



    private void executeQuery(String query){
        try {
            Statement stat = conn.createStatement();
//            if(stat.execute(query)) {
//                stat.getResultSet();
//            }
            stat.execute(query);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }

    }


    public void initWrite(Table<? extends Record> table) throws SQLException {

        if (conn == null ) return;
        deleteTable(table);

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CREATE TABLE ").append(schema).append(".").append(table.getName()).append("(");
        List<? extends Record> records = table.getRecords();

        for (String atr : table.getAttributes()){
            stringBuffer.append("`").append(atr).append("` ");
            SqlDatatypes sqlDatatypes = records.get(0).getSqlDatatypes(atr);

            List<String> recordsOfAtr = records.stream().map(rec -> rec.get(atr)).map(str -> cleanString(str,sqlDatatypes)).collect(Collectors.toList());

            stringBuffer.append(sqlDatatypes.datatypeString).append(SqlDatatypes.getSize(recordsOfAtr, sqlDatatypes)).append(",");
        }
        stringBuffer.append(" Primary Key (");
        table.getKeys().forEach(pk -> stringBuffer.append("`").append(pk).append("` ,")) ;
        stringBuffer.delete(stringBuffer.length()-1,stringBuffer.length());
        stringBuffer.append(")) DEFAULT CHARSET = utf8");
        executeQuery(stringBuffer.toString());

    }

    private String cleanString(String str, SqlDatatypes sqlDatatypes) {
        String returnString;
        Pattern pattern = Pattern.compile(sqlDatatypes.getRegex());
        Matcher matcher = pattern.matcher(str);

        if (matcher.find()) {
            returnString = matcher.group();
        } else {
            throw new RuntimeException("Keine Zahl wurde gefunden!");
        }

        if (returnString.contains(",") && sqlDatatypes.isNummeric()) return returnString.replace(",",".");
        return returnString;
    }

    public void close() {
        executeQuery("commit");
        conn = null;
        schema = null;
    }

    private void deleteTable(Table<? extends Record> table) {
        executeQuery("DROP TABLE IF EXISTS `"+ table.getName() +"`");
    }

    public void insertWrite(Table<? extends Record> table) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Insert into " + schema + "."+ table.getName() + " (");
        table.getAttributes().forEach(str -> stringBuffer.append("`" + str + "`, "));
        stringBuffer.deleteCharAt(stringBuffer.length() - 2).append(") Values ");
        for (Record rec : table.getRecords()) {
            stringBuffer.append(generateInsertValueString(rec));
        }
        stringBuffer.deleteCharAt(stringBuffer.length()-2);
        System.out.println(stringBuffer.toString());
        executeQuery(stringBuffer.toString());
    }


    private String generateInsertValueString(Record rec) {
        StringBuffer returnString = new StringBuffer().append("(");
        for (int i = 0; i < rec.getValues().size();i++) {
            List<String> values = rec.getValues();
            List<String> attributes = rec.attributes;
            if(rec.getSqlDatatypes(attributes.get(i)).isNummeric()){
//                Pattern pattern = Pattern.compile(rec.getSqlDatatypes(attributes.get(i)).getRegex());
//                Matcher matcher = pattern.matcher(values.get(i).replace(" ",""));
//                String result;
//                if (matcher.find()) {
//                    result = matcher.group();
//                } else {
//                    throw new RuntimeException("Keine Zahl wurde gefunden!");
//                }
//                if (rec.getSqlDatatypes(attributes.get(i)).equals(DOUBLE)) { //eig könnte man das noch in die SQLDaten Klasse schreiben
//                   result = result.replace(",", ".");
//                }
//                returnString.append(result + ", ");
                returnString.append(cleanString(values.get(i).replace(" ", ""), rec.getSqlDatatypes(attributes.get(i)))).append(", ");
            }

            if(!rec.getSqlDatatypes(attributes.get(i)).isNummeric()){
                returnString.append("\"").append(values.get(i)).append("\", ");
            }
        }
        returnString.deleteCharAt(returnString.length()-2).append("), ");
        return returnString.toString();
    }


}