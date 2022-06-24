package Classwork.DaySeven;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIOWithObjects {
    static final String delimiter = ",";

    public static void main(String[] args) {
        ArrayList<Person> people = ReadFile("./ExtraFiles/sales.txt");
        //I really could name these a lot better
        for (Person person : people) {
            System.out.println(person.getName() + " has a total of " + person.SumColumns());
        }

        List<Integer> attributeSums = SumEachAttribute(people);

        for (int i = 0; i < attributeSums.size(); i++) {
            System.out.println("The sum of column " + (i+1) + " is " + attributeSums.get(i));
        }
    }

    private static List<Integer> SumEachAttribute(List<Person> people)
    {
        //Set up array
        ArrayList<Integer> sums = new ArrayList<>();
        while (sums.size() < Person.numColumns) sums.add(0);

        for (Person person : people) {
            int[] data = person.getData();
            for (int i = 0; i < data.length; i++) {
                sums.set(i, sums.get(i) + data[i]);
            }
        }

        return sums;
    }

    public static ArrayList<Person> ReadFile(String path) {
        File fileName = new File(path); // If in Project folder
        ArrayList<Person> values = new ArrayList<>(); // Store the values

        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String lineFromFile;
            //int counter = 0;
            do {
                lineFromFile = br.readLine(); // Reads each line
                if (lineFromFile != null) {
                    String[] splitVals = lineFromFile.split(delimiter);

                    //Ignoring the fact that i need to validate the data
                    //Format: name, number, number
                    Person newPerson = new Person(
                            splitVals[0],
                            Integer.parseInt(splitVals[1]),
                            Integer.parseInt(splitVals[2])
                    );

                    values.add(newPerson);
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

