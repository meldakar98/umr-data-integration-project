package utils.JavaDataManager;

import Model.Laender;
import Model.McDonalds;
import Model.Record;
import Model.Training;
import utils.Database.database_Info.Table;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Verwaltung {
    List<Table<?extends Record>> tables;
    public Verwaltung()
    {
        tables=new ArrayList<>();
        parseExerciseCsvFile();
        parselaenderCsvFile();
        parseMcdonaldsCsvFile();
    }
    private void parselaenderCsvFile() {
        String current = "";
        String fileName="./0_datasets/durchschnitsgewicht_Lander.csv";
        Table<Laender> table;
        Dataholder dataholder= Dataholder.getInstance();
        try {

            FileReader fileReader=new FileReader(fileName);
            final BufferedReader reader = new BufferedReader(fileReader);
            current = reader.readLine();
            int c=Arrays.stream(current.split(";")).filter(s1 -> s1!="").toList().size();
            table=new Table<>("Laender", Arrays.stream(current.split(";")).filter(s1 -> s1!="").toList());
            Laender.setAttributes(current);
            current=reader.readLine();
            while (current != null) {
                if (Arrays.stream(current.split(";")).filter(s1 -> s1!="").toList().size()==c)
                {

                    dataholder.addElement(new Laender(current));
                    table.addRecord(new Laender(current));
                }
                current = reader.readLine();
            }

            table.findAndRemoveDuplicateLists();
            table.checkKeyIntegrety();
            Dataholder.getInstance().addTable(table);
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch (IllegalArgumentException e)
        {
            e.printStackTrace();

        }

    }
    private void parseExerciseCsvFile() {
        String current = "";
        String fileName="./0_datasets/exercise_dataset1.csv";
        Dataholder dataholder= Dataholder.getInstance();
        Table<Training> table;
        try {

            FileReader fileReader=new FileReader(fileName);
            final BufferedReader reader = new BufferedReader(fileReader);
            current = reader.readLine();
            int c=Arrays.stream(current.split(";")).filter(s1 -> s1!="").toList().size();

            table=new Table<>("Excercise", Arrays.stream(current.split(";")).filter(s1 -> s1!="").toList());

            Training.setAttributes(current);
            current=reader.readLine();
            while (current != null) {
                if (Arrays.stream(current.split(";")).filter(s1 -> s1!="").toList().size()==c) {

                    dataholder.addElement(new Training(current));
                    table.addRecord(new Training(current));
                }
                current = reader.readLine();
            }
            table.findAndRemoveDuplicateLists();
            table.checkKeyIntegrety();
            Dataholder.getInstance().addTable(table);

            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch (IllegalArgumentException e)
        {
            e.printStackTrace();

        }

    }
    private void parseMcdonaldsCsvFile() {
        String current = "";
        String fileName="./0_datasets/McDonalds_Nahrwertetabelle_fur_alle_Gerichte.csv";
        Dataholder dataholder= Dataholder.getInstance();
        Table<McDonalds> table;

        try {

            FileReader fileReader=new FileReader(fileName);
            final BufferedReader reader = new BufferedReader(fileReader);
            current = reader.readLine();
            table=new Table<>("Mcdonalds", Arrays.stream(current.split(";")).filter(s1 -> s1!="").toList());
            int c=Arrays.stream(current.split(";")).filter(s1 -> s1!="").toList().size();

            McDonalds.setAttributes(current);

            current=reader.readLine();
            while (current != null) {
                if (Arrays.stream(current.split(";")).filter(s1 -> s1!="").toList().size()==c) {

                    dataholder.addElement(new McDonalds(current));
                    table.addRecord(new McDonalds(current));
                }
                current = reader.readLine();
            }

            table.findAndRemoveDuplicateLists();
            table.checkKeyIntegrety();
            dataholder.addTable(table);
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch (IllegalArgumentException e)
        {
            e.printStackTrace();

        }

    }

    }

