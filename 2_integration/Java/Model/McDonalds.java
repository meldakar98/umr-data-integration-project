package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Model.SqlDatatypes.INT;
import static Model.SqlDatatypes.VARCHAR;

public class McDonalds extends Record{
    public static List<String> attributes;
    private String string="";
    public McDonalds(String s) {

        super(attributes,s);
        super.sqlDatatypes = new ArrayList<SqlDatatypes>(Arrays.asList(VARCHAR,VARCHAR,INT,INT,INT,INT,INT,INT));

        menu=get(attributes.get(0));
        menge=get(attributes.get(1));
        kj=get(attributes.get(2));
        kcal=get(attributes.get(3));
        energie=get(attributes.get(4));
        fett=get(attributes.get(5));
        kh=get(attributes.get(6));
        Einheit=get(attributes.get(7));
    }

    public static void setAttributes(String s)
    {
        attributes= Arrays.stream(s.split(";")).filter(s1 -> s1!="").toList();

    }
    String menu;
    String menge;
    String kj;
    String kcal;
    String energie;
    String fett;
    String kh;
    String Einheit;

}
