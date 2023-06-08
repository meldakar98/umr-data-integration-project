package Model;

import java.util.List;

public enum SqlDatatypes {
    VARCHAR(false,"VARCHAR","(.*)",String.class),
    INT(true,"INTEGER","(\\d+)",Integer.class),
    DOUBLE(true,"DOUBLE","(\\d+)([,.]*\\d*)",Double.class);
    public final boolean nummeric;
    public final String datatypeString;

    public Class javaDatentyp;

    public final String regex;
    private SqlDatatypes(boolean nummeric, String dtString, String regex, Class javaDatentyp){ //javaDatentyp war angedacht 
        this.nummeric=nummeric;
        this.datatypeString =dtString;
        this.regex = regex;
        this.javaDatentyp = javaDatentyp;
    }
    public boolean isNummeric() {
        return nummeric;
    }

    public String getDatatypeString() {
        return datatypeString;
    }

    public String getRegex() {
        return regex;
    }

    public Class getJavaDatentyp() {
        return javaDatentyp;
    }

    public static String getSize(List<String> records, SqlDatatypes type){
        switch (type){
            case VARCHAR -> {
                return getSizeVARCHAR(records);
            }
            case INT, DOUBLE -> {
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