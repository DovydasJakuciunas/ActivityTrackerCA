package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class App
{

    public static void main( String[] args ) throws FileNotFoundException {
        ArrayList<Activity> student = new ArrayList<Activity>();
        readFile("activity_data_10.csv", student);
        //System.out.println(System.getProperty("user.dir"));
    }

    public static void readFile(String fileName, ArrayList<Activity> activities) throws FileNotFoundException {
        File f = new File(fileName);
        Scanner in = new Scanner(f);
        String line;
        while(in.hasNextLine())
        {
            line = in.nextLine();
            Activity a = parseLine(line);
            activities.add(a);
        }
    }

    private static Activity parseLine(String line) {
        String activity;
        int duration;
        long date;
        double kilometer;
        int averageHeartRate;

        StringTokenizer act = new StringTokenizer(line, ",");

        activity = act.nextToken();
        duration = Integer.parseInt(act.nextToken().trim());
        date = Date.parse(act.nextToken().trim());
        kilometer = Double.parseDouble(act.nextToken().trim());
        averageHeartRate = Integer.parseInt(act.nextToken().trim());

        return new Activity(activity,duration,date,kilometer,averageHeartRate);


    }
}
