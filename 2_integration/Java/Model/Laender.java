package Model;

import java.util.Arrays;
import java.util.List;

public class Laender {
    static List<String> attributes;
    private String string="";
    public static void setAttributes(String s)
    {
        attributes= Arrays.stream(s.split(",")).filter(s1 -> s1!="").toList();
        System.out.println(attributes.size());
    }
    public Laender(String s)
    {
        List<String> list= Arrays.stream(s.split(",")).filter(s1 -> s1!="").toList();
        groesseMan=list.get(1);
        gewichtMan=list.get(2);
        BMIMan=list.get(3);
        groesseFrau=list.get(4);
        gewichtFrau=list.get(5);
        BMIManFrau=list.get(6);
        name=list.get(0);

    }
    String name;
    String  gewichtMan;
    String groesseMan;
    String BMIMan;
    String gewichtFrau;
    String groesseFrau;
    String BMIManFrau;

}
