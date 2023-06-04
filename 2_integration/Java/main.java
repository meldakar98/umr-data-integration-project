import Model.Laender;
import Model.McDonalds;
import Model.Training;
import utils.Dataholder;
import utils.KeyFinder;
import utils.Verwaltung;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class main {
    public static void main(String[] args) {

        Verwaltung v=new Verwaltung();

        System.out.println("jsjsjs"+Dataholder.getInstance().getLaender().size());

        System.out.println(Dataholder.getInstance().getLaender().get(5).getCommaSeparatedString());
        System.out.println(Training.getAttributes());
        System.out.println("size of sets are " + Dataholder.getInstance().getTraining().size()+",,,"+Dataholder.getInstance().getLaender().size()+",,,,"+Dataholder.getInstance().getMcDonalds().size());
        System.out.println(Dataholder.getInstance().getMcDonalds());
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
        KeyFinder kf=new KeyFinder();
        List<String> list=new ArrayList<>();
        list.add(Laender.attributes.get(0));
        System.out.println(kf.isKey(list,Dataholder.getInstance().getMcDonalds()));

    }
}
