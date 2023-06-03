package Model;

import java.util.Arrays;
import java.util.List;

public class McDonalds implements Record{
    static List<String> attributes;
    private String string="";

    public McDonalds(String s) {
        List<String> list= Arrays.stream(s.split(",")).filter(s1 -> s1!="").toList();
        menu=list.get(0);
        menge=list.get(1);
        kj=list.get(2);
        kcal=list.get(3);
        energie=list.get(4);
        fett=list.get(5);
        kh=list.get(6);
    }

    public static void setAttributes(String s)
    {
        attributes= Arrays.stream(s.split(",")).filter(s1 -> s1!="").toList();
        System.out.println(attributes.size());
    }
    String menu;
    String menge;
    String kj;
    String kcal;
    String energie;
    String fett;
    String kh;

    @Override
    public String getCommaSeparatedString() {
        //TODO
        return null;
    }

    @Override
    public List<String> getValues() {
        //TODO
        return null;
    }

    @Override
    public String get(String s) {
        //TODO
        return null;
    }
}
