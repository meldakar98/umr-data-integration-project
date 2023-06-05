import Model.Laender;
import Model.McDonalds;
import Model.Training;
import utils.DBManager;
import utils.Dataholder;
import utils.KeyFinder;
import utils.Verwaltung;
import utils.database_Info.Table;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static Model.SqlDatatypes.DOUBLE;

public class main {
    public static void main(String[] args) {

        Verwaltung v=new Verwaltung();

//
//        System.out.println("jsjsjs"+Dataholder.getInstance().getLaender().size());
//
//        System.out.println(Dataholder.getInstance().getLaender().get(5).getCommaSeparatedString());
//        System.out.println(Training.getAttributes());
//        System.out.println("size of sets are " + Dataholder.getInstance().getTraining().size()+",,,"+Dataholder.getInstance().getLaender().size()+",,,,"+Dataholder.getInstance().getMcDonalds().size());
//        System.out.println(Dataholder.getInstance().getMcDonalds());
//        Set<String> set=new HashSet<>();
//        Set<String> set2=new HashSet<>();
//        set.add("A");
//        set.add("B");
//        set2.add("A");
//        set2.add("B");
//        Set<Set<String>> sets=new HashSet<>();
//        sets.add(set);
//        sets.add(set2);
//
//        System.out.println(set.equals(set2));
//        System.out.println(sets);
//        KeyFinder kf=new KeyFinder();
//        List<String> list=new ArrayList<>();
//       System.out.println("jasjasjjsa"+Dataholder.getInstance().getTraining());
//       System.out.println(Dataholder.getInstance().tables.get(0).getAttributes());
//       System.out.println(Dataholder.getInstance().tables.get(0).getRecords());
//        System.out.println(Dataholder.getInstance().getTraining().get(20).getKcal_stufe_drei());
//            for (Table t: Dataholder.getInstance().tables){
//                new DBManager().write(t);


//            }
        String input = "es soll nur 1,56 m gewält werden und nicht die 1,56";
        final Pattern pattern = Pattern.compile("^.*\\d,\\d\\d.*$", Pattern.CASE_INSENSITIVE);
        // Match regex against input
        final Matcher matcher = pattern.matcher(input);
        // Use results...
        
        System.out.println(matcher.matches());

//        List<String> test = Arrays.asList("1,84 m");
////        List<String> result = test.stream().map(s -> s.split()).collect(Collectors.toList());
////        System.out.println("");
//        System.out.println("1,84 m".split("(\\s\\bm\\b)")[0]);
//        System.out.println(Dataholder.getInstance().tables.get(1).getAttributes());
//        System.out.println(Dataholder.getInstance().tables.get(1).getRecords());
//        System.out.println(Dataholder.getInstance().tables.get(2).getAttributes());
//        System.out.println(Dataholder.getInstance().tables.get(2).getRecords());
//        System.out.println(kf.isKey(list,Dataholder.getInstance().getTraining()));

    }
}
