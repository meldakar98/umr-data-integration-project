package Model;

public enum SqlDatatypes {
    VARCHAR(false,"VARCHAR"),INT(true,"INTEGER"),DOUBLE(true,"DOUBLE");
    public final boolean nummeric;
    public final String DatatypeString;
    private SqlDatatypes(boolean nummeric,String dtString){
        this.nummeric=nummeric;
        this.DatatypeString=dtString;
    }
}
