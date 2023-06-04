package Model;

public enum SqlDatatypes {
    VARCHAR(false,"VARCHAR","(.)"),INT(true,"INTEGER","([0-9])"),DOUBLE(true,"DOUBLE","^[+-]?\\d+(?:[.,]\\d+)?$");
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
}