package utils;

import Model.Record;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeyFinder {
    public boolean isKey(List<String> candidate, List<Record> records)
    {
        Set<Set<String>> sets=new HashSet<>();
        for (Record r: records
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
