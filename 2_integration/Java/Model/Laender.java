package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.DoubleAdder;

import static Model.SqlDatatypes.DOUBLE;
import static Model.SqlDatatypes.VARCHAR;

public class Laender  extends Record{
    public static List<String> attributes;
    private String string="";
    private final static List<SqlDatatypes> SQL_DATATYPES = new ArrayList<SqlDatatypes>(Arrays.asList(VARCHAR,DOUBLE,DOUBLE,DOUBLE,DOUBLE,DOUBLE,DOUBLE));
    public static void setAttributes(String s)
    {
        attributes= Arrays.stream(s.split(";")).filter(s1 -> s1!="").toList();

    }
    public Laender(String s)
    {
        super(attributes,s);
        name=get(attributes.get(0));
        groesseMan=get(attributes.get(1));
        gewichtMan=get(attributes.get(2));
        BMIMan=get(attributes.get(3));
        groesseFrau=get(attributes.get(4));
        gewichtFrau=get(attributes.get(5));
        BMIManFrau=get(attributes.get(6));


    }
    String name;
    String  gewichtMan;
    String groesseMan;
    String BMIMan;
    String gewichtFrau;
    String groesseFrau;
    String BMIManFrau;

}
