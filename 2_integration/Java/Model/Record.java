package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Record {
     List<String> attributes;
     Map<String,String> values;
    public Record(List<String> attributes,List<String> v)
    {
        this.attributes=attributes;
        this.values= new HashMap<String,String>();
        if(attributes.size()==v.size())
        {
            for (int i = 0; i < attributes.size(); i++) {
                values.put(attributes.get(i),v.get(i));
            }
        }

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
