package Model;

import java.util.*;

public class Record {
     public List<String> attributes;
     Map<String,String> values;
     @Override
     public boolean equals(Object o)
     {
        Record o2=(Record) o;
        if(this.getValues().size()!=o2.getValues().size())
        {
            System.out.println("not equal");
            return false;
        }
         for (int i = 0; i <this.getValues().size() ; i++) {
             if(!this.getValues().get(i).equals(this.getValues().get(i)))
                 return false;
         }
        return true;
     }
    @Override
    public int hashCode() {
        return  getValues().get(0).hashCode() + getValues().get(1).hashCode()+ getValues().get(2).hashCode();
    }
    public Record(List<String> attributes,String s)
    {
        this.attributes=attributes;
        this.values= new HashMap<String,String>();
        List<String> v= Arrays.stream(s.split(";")).filter(s1 -> s1!="").toList();

        if(attributes.size()==v.size())
        {
            for (int i = 0; i < attributes.size(); i++) {
                values.put(attributes.get(i),v.get(i));
            }
        }

    }
    @Override
    public String toString()
    {
        return getCommaSeparatedString();
    }

    public  String getCommaSeparatedString(){
        String resul="";
        for (int i = 0; i < attributes.size()-1; i++) {
            resul=resul+values.get(attributes.get(i))+",";
        }
        resul=resul+values.get(attributes.get(attributes.size()-1));
        return resul;
    }
    public  List<String> getValues(){
        List<String> res=new ArrayList<>();
        for (int i = 0; i < attributes.size() ; i++) {
            res.add(values.get(attributes.get(i)));
        }
        return res;
    }

    public  String get(String s){

        return values.get(s);
    }
}
