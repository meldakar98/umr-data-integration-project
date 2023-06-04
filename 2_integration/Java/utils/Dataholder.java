package utils;

import Model.Laender;
import Model.McDonalds;
import Model.Record;
import Model.Training;
import utils.database_Info.Table;

import java.util.ArrayList;
import java.util.List;

public class Dataholder {
    public List<Table<? extends Record>> tables;
    private static Dataholder instance=null;
    List<Laender> laender ;

    public List<Training> getTraining() {
        return training;
    }

    public List<McDonalds> getMcDonalds() {
        return mcDonalds;
    }

    List<McDonalds> mcDonalds;

    List<Training>  training;
    public void addElement(Laender l)
    {
        laender.add(l);
    }
    public void addElement(McDonalds l)
    {
        mcDonalds.add(l);
    }
    public void addElement(Training l)
    {
        training.add(l);
    }
    private Dataholder()
    {
        laender=new ArrayList<>();
        training=new ArrayList<>();
        mcDonalds=new ArrayList<>();
        tables=new ArrayList<>();

    }
    public void addTable(Table<? extends Record> t)
    {
        tables.add(t);
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
