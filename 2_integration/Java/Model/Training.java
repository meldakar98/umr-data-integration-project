package Model;

import java.util.Arrays;
import java.util.List;

public class Training {

    String aktivitaet;
    int kcal_stufe_eins;
    int kcal_stufe_zwei;
    int kcal_stufe_drei;
    int kcal_stufe_vier;
    double kcal_per_kg;
    public Training(String s)
    {

        List<String> list= Arrays.stream(s.split(",")).filter(s1 -> s1!="").toList();
        aktivitaet=list.get(0);
        kcal_stufe_zwei=Integer.parseInt(list.get(2));
        kcal_stufe_eins=Integer.parseInt(list.get(1));
        kcal_stufe_drei=Integer.parseInt(list.get(3));
        kcal_stufe_vier=Integer.parseInt(list.get(4));;
        kcal_per_kg=Double.parseDouble(list.get(5));
    }

    static List<String> attributes;
    private String string="";
    public static void setAttributes(String s)
    {
        attributes= Arrays.stream(s.split(",")).filter(s1 -> s1!="").toList();
        System.out.println(attributes.size());
    }

}
