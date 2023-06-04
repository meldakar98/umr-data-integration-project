package utils;

import Model.Laender;
import Model.McDonalds;
import Model.Record;
import Model.Training;
import utils.database_Info.Table;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        Dataholder dataholder= Dataholder.getInstance();
        try {

            FileReader fileReader=new FileReader(fileName);
            final BufferedReader reader = new BufferedReader(fileReader);
            current = reader.readLine();

            Laender.setAttributes(current);
            System.out.println("Attributes of Land"+Laender.attributes);
            current=reader.readLine();
            while (current != null) {
                dataholder.addElement(new Laender(current));

                current = reader.readLine();
            }
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
        try {

            FileReader fileReader=new FileReader(fileName);
            final BufferedReader reader = new BufferedReader(fileReader);
            current = reader.readLine();
            Training.setAttributes(current);
            current=reader.readLine();
            while (current != null) {
                dataholder.addElement(new Training(current));

                current = reader.readLine();
            }
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
        try {

            FileReader fileReader=new FileReader(fileName);
            final BufferedReader reader = new BufferedReader(fileReader);
            current = reader.readLine();
            McDonalds.setAttributes(current);
            current=reader.readLine();
            while (current != null) {
                dataholder.addElement(new McDonalds(current));

                current = reader.readLine();
            }
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

