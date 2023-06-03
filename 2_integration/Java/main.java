import Model.McDonalds;
import Model.Training;
import utils.Dataholder;
import utils.Verwaltung;

import java.util.HashSet;
import java.util.Set;

public class main {
    public static void main(String[] args) {
        /*
        Verwaltung v=new Verwaltung();
        v.init();
        System.out.println(Dataholder.getInstance().getLaender().size());

        System.out.println(Dataholder.getInstance().getTraining().get(2).getCommaSeparatedString());
        System.out.println(Training.getAttributes());
        */
        Set<String> set=new HashSet<>();
        Set<String> set2=new HashSet<>();
        set.add("A");
        set.add("B");
        set2.add("A");
        set2.add("B");
        Set<Set<String>> sets=new HashSet<>();
        sets.add(set);
        sets.add(set2);

        System.out.println(set.equals(set2));
        System.out.println(sets);



    }
}
