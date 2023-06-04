package Model;

import java.util.Arrays;
import java.util.List;

public class McDonalds extends Record{
    public static List<String> attributes;
    private String string="";

    public McDonalds(String s) {

        super(attributes,s);

        menu=get(attributes.get(0));
        menge=get(attributes.get(1));
        kj=get(attributes.get(2));
        kcal=get(attributes.get(3));
        energie=get(attributes.get(4));
        fett=get(attributes.get(5));
        kh=get(attributes.get(6));
    }

    public static void setAttributes(String s)
    {
        attributes= Arrays.stream(s.split(";")).filter(s1 -> s1!="").toList();
        System.out.println(attributes.size());
    }
    String menu;
    String menge;
    String kj;
    String kcal;
    String energie;
    String fett;
    String kh;

}
