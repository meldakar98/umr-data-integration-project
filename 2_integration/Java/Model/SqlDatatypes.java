package Model;

import java.util.List;
import java.util.OptionalInt;

public enum SqlDatatypes {
    VARCHAR(false,"VARCHAR","(.)"),
    INT(true,"INTEGER","([0-9])"),
    DOUBLE(true,"DOUBLE","[0-9]+([.,][0-9]+)?[a-zA-Z]*");
    public final boolean nummeric;
    public final String DatatypeString;

    public final String regex;
    private SqlDatatypes(boolean nummeric,String dtString,String regex){
        this.nummeric=nummeric;
        this.DatatypeString=dtString;
        this.regex = regex;
    }
    public boolean isNummeric() {
        return nummeric;
    }

    public String getDatatypeString() {
        return DatatypeString;
    }

    public String getRegex() {
        return regex;
    }

    public static String getSize(List<String> records, SqlDatatypes type){
        switch (type){
            case VARCHAR -> {
                return getSizeVARCHAR(records);
            }
            case INT -> {
                return getSizeINT(records);
            }
            case DOUBLE -> {
                return getSizeDOUBLE(records);
            }
        }

        return null;
    }

    private static String getSizeDOUBLE(List<String> records) {

       int afterDecimal = records.stream().map(s -> s.split("^.*?\\.")).mapToInt(value -> value[1].length()).max().getAsInt();

       int infrontDecimal = records.stream().map(s -> s.split("\\..*")).mapToInt(value ->
               value[0].length()).max().getAsInt();

       return "("+infrontDecimal+","+afterDecimal+")";
    }

    private static String getSizeINT(List<String> records) {

//        return String.valueOf(String.valueOf(records.stream().mapToInt(integer -> Integer.parseInt(integer)).max().getAsInt()).length());
        return "(" + String.valueOf(records.stream().mapToInt(integer -> integer.length()).max().getAsInt()) + ")";
    }

    private static String getSizeVARCHAR(List<String> records) {
        return getSizeINT(records);
    }
}