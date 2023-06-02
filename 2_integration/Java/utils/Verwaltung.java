package utils;

import Model.Laender;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Verwaltung {

    public void parselaenderCsvFile() {
        String current = "";
        String fileName="/home/zaza/Desktop/Work/Data Integration/umr-data-integration-project/0_datasets/durchschnitsgewicht_Lander.csv";
        Dataholder dataholder= Dataholder.getInstance();
        try {

            FileReader fileReader=new FileReader(fileName);
            final BufferedReader reader = new BufferedReader(fileReader);
            current = reader.readLine();
            Laender.setAttributes(current);
            current=reader.readLine();
            while (current != null) {
                current = reader.readLine();
                dataholder.addElement(new Laender(current));
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

