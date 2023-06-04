package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Training extends Record{

    String aktivitaet;
    String kcal_stufe_eins;
    String kcal_stufe_zwei;
    String kcal_stufe_drei;
    String kcal_stufe_vier;
    String kcal_per_kg;
    /*
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
    */
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
        System.out.println(attributes.size());


    }

    @Override
    public String getCommaSeparatedString() {
        return "(" + aktivitaet+","+kcal_stufe_eins+","+kcal_stufe_zwei+","+kcal_stufe_drei+","+kcal_stufe_vier+","+kcal_per_kg + ")";
    }

    @Override
    public List<String> getValues() {
        List<String> values=new ArrayList<>();
        values.add(aktivitaet);
        values.add(kcal_stufe_eins);
        values.add(kcal_stufe_zwei);
        values.add(kcal_stufe_drei);
        values.add(kcal_stufe_vier);
        values.add(kcal_per_kg);

        return values;
    }

    @Override
    public String get(String s) {
        int i=0;
        boolean found=false;
        for (String s1:attributes
             ) {
            if(s.equals(s1))
            {
                found= true;
                break;
            }
            i++;

        }

        return getValues().get(i);
    }
}
