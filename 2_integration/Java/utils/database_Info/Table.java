package utils.database_Info;

import Model.Record;

import java.util.*;
import java.util.stream.Collectors;

public class Table<T extends Record> {
    String name;
    List<String> attributes;

    List<String> keys;
    List<Map<String,Table<? extends Record>>> forignKeys;

    List<T> records;
    public Table(String name, List<String> attributes) {
        this.name = name;
        this.attributes = attributes;
        this.records = new ArrayList<>();

    }
    public void addRecord(T r)
    {
        records.add(r);
    }
    public boolean checkIntegrety()
    {
        if(keys!=null)
        {
            return isKey(keys);
        }
        else {
            return false;
        }
    }
    private List<String> getCandidates()
    {
        List<String> res=new ArrayList<>();

        return res;

    }

    public boolean isKey(List<String> candidate)
    {
        Set<Set<String>> sets=new HashSet<>();
        for (T r: records
        ) {
            Set<String> set =new HashSet<>();
            for (String s: candidate
            ) {
                set.add(r.get(s));
            }
            sets.add(set);
        }
        System.out.println();
        System.out.println(sets);
        return sets.size()==records.size();
    }


    public String getName() {
        return name;
    }

    public List<String> getAttributes() {
        return attributes;
    }

    public List<T> getRecords() {
        return records;
    }
    public int getSize()
    {
        return records.size();
    }

    public List<String> getKeys() {
        return keys;
    }

    public List<Map<String, Table<? extends Record>>> getForignKeys() {
        return forignKeys;
    }

    public static List<List<String>> generateCombinations(List<String> arr) {
        List<List<String>> combinations = new ArrayList<>();
        generateCombinationsHelper(arr, 0, new ArrayList<>(), combinations);
        return combinations;
    }

    private static void generateCombinationsHelper(List<String> arr, int index, List<String> currentCombination, List<List<String>> combinations) {
        combinations.add(new ArrayList<>(currentCombination));

        for (int i = index; i < arr.size(); i++) {
            currentCombination.add(arr.get(i));
            generateCombinationsHelper(arr, i + 1, currentCombination, combinations);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }


}
