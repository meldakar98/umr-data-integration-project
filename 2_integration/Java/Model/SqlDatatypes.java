package Model;

import utils.Dataholder;

import java.util.List;
import java.util.OptionalInt;

public enum SqlDatatypes {
    VARCHAR(false,"VARCHAR","(.*)"),
    INT(true,"INTEGER","(\\d+)"),
    DOUBLE(true,"DOUBLE","(\\d+)([,.]*\\d*)");
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
            case INT  -> {
                return "";
            }
            case DOUBLE -> {
                return "";
            }
        }

        return null;
    }
    @Deprecated(since = "Anscheinend wurden die längendefinitionen von Double werten neudings abgeschaft, werden nicht mehr gebraucht!")
    private static String getSizeDOUBLE(List<String> records) {

       int afterDecimal = records.stream().map(s -> s.split("^.*?\\.")).mapToInt(value -> value.length > 1 ? value[1].length() : 0).max().getAsInt();

       int frontDecimal = records.stream().map(s -> s.split("\\..*")).mapToInt(value ->
               value[0].length()).max().getAsInt();



        return "("+ (frontDecimal < afterDecimal ? afterDecimal : frontDecimal) +","+afterDecimal+")";
    }

    private static String getSizeVARCHAR(List<String> records) {
        return "(" + String.valueOf(records.stream().mapToInt(str -> str.length()).max().getAsInt()) + ")";
    }
}