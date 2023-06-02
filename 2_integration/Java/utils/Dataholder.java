package utils;

import Model.Laender;

import java.util.ArrayList;
import java.util.List;

public class Dataholder {
    private static Dataholder instance=null;
    List<Laender> laender =null;
    public void addElement(Laender l)
    {
        laender.add(l);
    }
    private Dataholder()
    {
        laender=new ArrayList<>();

    }
    public static Dataholder getInstance(){
        if(instance==null)
            instance=new Dataholder();
    return instance;
    }
    public List<Laender> getLaender()
    {
        return laender;
    }
}
