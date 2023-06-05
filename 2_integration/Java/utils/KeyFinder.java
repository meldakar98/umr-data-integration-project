package utils;

import Model.Record;
import Model.Training;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeyFinder {
    public boolean isKey(List<String> candidate, List<? extends Record> records)
    {
        Set<Set<String>> sets=new HashSet<>();
        for (Record r: records
             ) {
            Set<String> set =new HashSet<>();
            for (String s: candidate
                 ) {
                set.add(r.get(s));
            }
            System.out.println(set);
            sets.add(set);
        }
        System.out.println("sksdd");
        System.out.println(sets.size());
        System.out.println(records.size());
        return sets.size()==records.size();
    }

}
