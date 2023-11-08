package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.FormatStyle;
import java.util.*;

public class App
{

    public static void main( String[] args ) throws FileNotFoundException, ParseException {
        ArrayList<Activity> activities = new ArrayList<Activity>();
        readFile("activity_data_10.csv", activities);
        //System.out.println(System.getProperty("user.dir"));
        display(activities);

        for (Activity act : activities)
        {
            System.out.printf("%4.2f\n",EnergyExpended(act.getKilometer(),act.getDuration()));
        }
        for (Activity act :activities)
        {
            double Numbers=EnergyExpended(act.getKilometer(), act.getDuration());
        }
    }
    public static double EnergyExpended(double kilometer, int duration)
    {
        return   duration/kilometer;

    }
    public static int CaloriesBurned(double Numbers,String activity,int duration)
    {


        return 1;
    }


    //All to do with reading and display *Tab has 4 characters in it
    public static void display(ArrayList<Activity> activities){
        System.out.printf("%-15s %-11s %-10s %-10s %-20s\n","Activity Type","Date","Duration","Distance","Average Heart Rate");
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY");
        for (Activity act: activities)
        {
            System.out.printf("%-15s %-11s %-10d %-10.2f %-5d\n", act.getActivity(), df.format(act.getDate()), act.getDuration(), act.getKilometer(), act.getAverageHeartRate());
        }
    }
    public static void readFile(String fileName, ArrayList<Activity> activities) throws FileNotFoundException, ParseException {
        File f = new File(fileName);
        Scanner in = new Scanner(f);
        String line;
        line = in.nextLine();
        while(in.hasNextLine())
        {
            line = in.nextLine();
            Activity a = parseLine(line);
            activities.add(a);
        }
    }
    private static Activity parseLine(String line) throws ParseException {
        String activity;
        int duration;
        Date date;
        double kilometer;
        int averageHeartRate;

        StringTokenizer act = new StringTokenizer(line, ",");

        activity = act.nextToken();

        String dateStr = act.nextToken().trim();
        String[] dates = dateStr.split("/");
        //date = new Date(Integer.parseInt(dates[2])-1900,Integer.parseInt(dates[1])-1,Integer.parseInt(dates[0]));
        date = DateFormat.getDateInstance(DateFormat.SHORT, Locale.UK).parse(dateStr);

        duration = Integer.parseInt(act.nextToken().trim());

        kilometer = Double.parseDouble(act.nextToken().trim());

        averageHeartRate = Integer.parseInt(act.nextToken().trim());

        return new Activity(activity,duration,date,kilometer,averageHeartRate);


    }
}
