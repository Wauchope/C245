package Classwork.DaySeven;

import java.io.*;
import java.util.ArrayList;

public class FileIO {
    static final String delimiter = ",";

    public static void main(String[] args) {
        ArrayList<String> values = ReadFile("./ExtraFiles/sales.txt");
        ArrayList<Integer> entrySums = SumEachEntry(values);
        ArrayList<Integer> attributeSums = SumEachAttribute(values);


        System.out.println(entrySums);
        System.out.println(attributeSums);
    }

    private static ArrayList<Integer> SumEachAttribute(ArrayList<String> values) {
        assert values.size() > 0;

        ArrayList<Integer> sums = new ArrayList<>();

        for (String value : values) {
            //Get the current value and split it by delimiter;
            String[] splitVals = value
                    .split(delimiter);

            //Sum each attribute
            for (int j = 1; j < splitVals.length; j++) {
                int val = Integer.parseInt(splitVals[j]);
                if (sums.size() < j) {
                    sums.add(val);
                } else {
                    sums.set(j - 1, sums.get(j - 1) + val);
                }
            }
        }

        return sums;
    }

    private static ArrayList<Integer> SumEachEntry(ArrayList<String> values) {
        assert values.size() > 0;

        ArrayList<Integer> sums = new ArrayList<>();
        for (int i = 0; i < values.size(); i++) {
            //Get the current value and split it by delimiter;
            String[] splitVals = values.get(i)
                    .split(delimiter);

            //Sum each row
            for (int j = 1; j < splitVals.length; j++) {
                int val = Integer.parseInt(splitVals[j]);
                if (sums.size() < i+1) {
                    sums.add(val);
                } else {
                    sums.set(i, sums.get(i) + val);
                }
            }
        }

        return sums;
    }

    public static ArrayList<String> ReadFile(String path) {
        File fileName = new File(path); // If in Project folder
        ArrayList<String> values = new ArrayList<>(); // Store the values

        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String lineFromFile;
            //int counter = 0;
            do {
                lineFromFile = br.readLine(); // Reads each line
                if (lineFromFile != null) {
                    values.add(lineFromFile);
                }
                //  counter++;
            } while (lineFromFile != null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Can't find file");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return values;
    }
}

