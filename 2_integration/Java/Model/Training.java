package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static Model.SqlDatatypes.*;

public class Training extends Record{

    String aktivitaet;
    String kcal_stufe_eins;
    String kcal_stufe_zwei;
    String kcal_stufe_drei;
    String kcal_stufe_vier;

    List<SqlDatatypes> sqlDatatypes = new ArrayList<SqlDatatypes>(Arrays.asList(VARCHAR,INT,INT,INT,INT,DOUBLE));
    public String getAktivitaet() {
        return aktivitaet;
    }

    public String getKcal_stufe_eins() {
        return kcal_stufe_eins;
    }

    public String getKcal_stufe_zwei() {
        return kcal_stufe_zwei;
    }

    public String getKcal_stufe_drei() {
        return kcal_stufe_drei;
    }

    public String getKcal_stufe_vier() {
        return kcal_stufe_vier;
    }

    public String getKcal_per_kg() {
        return kcal_per_kg;
    }

    String kcal_per_kg;
    public Training(String s)
    {
        super(attributes,s);

        aktivitaet=get(attributes.get(0));
        kcal_stufe_zwei=get(attributes.get(2));
        kcal_stufe_eins=get(attributes.get(1));
        kcal_stufe_drei=get(attributes.get(3));
        kcal_stufe_vier=get(attributes.get(4));
        kcal_per_kg=get(attributes.get(5));
    }

    public static List<String> getAttributes() {
        return attributes;
    }

    public static List<String> attributes;
    private String string="";
    public static void setAttributes(String s)
    {
        attributes= Arrays.stream(s.split(";")).filter(s1 -> s1!="").toList();



    }


    @Override
    public List<SqlDatatypes> getSqlDatatypes() {
        return this.sqlDatatypes;
    }
}
