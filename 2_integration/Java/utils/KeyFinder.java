package utils;

import Model.Record;
import Model.Training;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeyFinder {
    public boolean isKey(List<String> candidate, List<Training> records)
    {
        Set<Set<String>> sets=new HashSet<>();
        for (Training r: records
             ) {
            Set<String> set =new HashSet<>();
            for (String s: candidate
                 ) {
                set.add(r.get(s));
            }
            sets.add(set);
        }
        return sets.size()==records.size();
    }

}
