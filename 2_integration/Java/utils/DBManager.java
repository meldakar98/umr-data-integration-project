package utils;

import Model.Record;
import Model.SqlDatatypes;
import utils.database_Info.Database_Settings;
import utils.database_Info.Table;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DBManager implements DBWriter<Record> {
    private Connection conn;

    public void setup(Database_Settings custom_db_settings) {
        try {
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



    public ResultSet executeQuery(String query){
        try {
            Statement stat = conn.createStatement();
            if(stat.execute(query)) {
                return stat.getResultSet();
            }
            return null;
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
            return null;
        }

    }

    public static void main(String[] args) throws SQLException {
//        DBManager dbman = new DBManager();
//        dbman.setup(new Database_Settings("dataintegration","root","1234"));
//        ResultSet rs = dbman.executeQuery("SHOW KEYS FROM dataintegration.laender WHERE Key_name = 'PRIMARY'");
//        ResultSetMetaData metaData = rs.getMetaData();
//        System.out.println(metaData.getColumnCount());
////        while (rs.next()){
////            System.out.println("Name:" +  rs.getString(3));
////        }
//
//            StringBuffer buf = new StringBuffer();
//            buf.append("[");
//            try {
////                ResultSetMetaData metaData = rs.getMetaData();
//                int nColumns = metaData.getColumnCount();
//                rs.next();
//                for (int i = 1; i <= nColumns; ++i) {
//                    buf.append(metaData.getColumnName(i));
//                    buf.append(" = ");
//                    System.out.println(i);
//                    buf.append(rs.getString(i));
//                    if (i < nColumns)
//                        buf.append(" , ");
//                }
//            } catch (SQLException e) {
//                buf.append(e.getMessage());
//                e.printStackTrace();
//            }
//            buf.append("]");
//
//        System.out.println(buf.toString());
      Object test =  SqlDatatypes.getSize(Arrays.asList("12.44555532","0.82323562985074605"),SqlDatatypes.DOUBLE);

    }

    @Override
    public void write(Table<Record> table) {
        String attributes = table.getAttributes().stream().collect(Collectors.joining(","));

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CREATE TABLE " + table.getName() + "(");
        List<Record> records = table.getRecords();

        for (String atr : table.getAttributes()){
            stringBuffer.append("`" + atr + "` ");
            SqlDatatypes sqlDatatypes = records.get(0).getSqlDatatypes(atr);

            List<String> recordsOfAtr = records.stream().map(rec -> rec.get(atr)).map(str -> {
                Pattern pattern = Pattern.compile(sqlDatatypes.getRegex());
                Matcher matcher = pattern.matcher(str);

                if (matcher.find()) {
                    return matcher.group();
                } else {
                    throw new RuntimeException("Keine Zahl wurde gefunden!");
                }
            }).map(mapedrec -> {
                if (mapedrec.contains(",") && sqlDatatypes.isNummeric()) return mapedrec.replace(",",".");
                return mapedrec;
                }).collect(Collectors.toList());

            stringBuffer.append(sqlDatatypes.DatatypeString + SqlDatatypes.getSize(recordsOfAtr,sqlDatatypes) + ",");
        }
        table.getForignKeys();
        stringBuffer.delete(stringBuffer.length()-1,stringBuffer.length());
        stringBuffer.append(")");


    }
}