package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class App
{

    public static void main( String[] args ) throws FileNotFoundException, ParseException {
        ArrayList<Activity> activities = new ArrayList<Activity>();
        readFile("activity_data_10.csv", activities);
        //System.out.println(System.getProperty("user.dir"));



        MainMenu(activities);

        //CaloriesBurned(activities);
        //Intensity(activities);



    }

    private static void MainMenu(ArrayList<Activity> activities)
    {

        DisplayMenu menu = new DisplayMenu(activities);
        //menu.display();
        //menu.displayDateAscending();
        //menu.displayDateDescending();
        //menu.displayDurationAscending();
        //menu.displayDurationDescending();
        //menu.displayTypeOfActivity();
        //menu.displayDistanceAscending();
        //menu.displayDistanceDescending();

        System.out.println("Welcome to The Best Activity Tracker");
        System.out.println("Please select any of the following options to view your stats");
        Scanner kb = new Scanner(System.in);
        int choice = 0;
        do {

        }
        while(choice!=0);
    }
    private static void printMenu()
    {
        System.out.printf("%2f %58s", 1, "Exit");

    }


    private static void Intensity(ArrayList<Activity> activities)
    {
        String intesity = null;
        for (Activity act: activities)
        {
            if (act.getActivity().equals("Running"))
            {
                    if (act.EnergyExpended() <= 4)
                    {
                        intesity = "Very Light";
                    } else if (act.EnergyExpended() >4 &&act.EnergyExpended()<=8) {
                        intesity = " Light";
                    }
                    else if (act.EnergyExpended() >8 &&act.EnergyExpended()<=12) {
                        intesity = "Moderate";
                    }
                    else if (act.EnergyExpended() >12 &&act.EnergyExpended()<=16) {
                        intesity = "Vigorous";
                    }
                    else if (act.EnergyExpended() >16 &&act.EnergyExpended()<=24) {
                        intesity = "Very Vigorous";
                    }
                    else {
                        System.out.println("Should not exist"+" - "+ act.getActivity());
                    }
                System.out.println(intesity+" - "+ act.getActivity());
            }
            else if (act.getActivity().equals("Cycling"))
            {
                    if (act.EnergyExpended() <= 8)
                    {
                        intesity = "Very Light";
                    } else if (act.EnergyExpended() >8 &&act.EnergyExpended()<=16) {
                        intesity = " Light";
                    }
                    else if (act.EnergyExpended() >17 &&act.EnergyExpended()<=25) {
                        intesity = "Moderate";
                    }
                    else if (act.EnergyExpended() >25 &&act.EnergyExpended()<=33) {
                        intesity = "Vigorous";
                    }
                    else if (act.EnergyExpended() >33 &&act.EnergyExpended()<=40) {
                        intesity = "Very Vigorous";
                    }
                    else {
                        System.out.println("Should not exist"+" - "+ act.getActivity());
                    }
                    System.out.println(intesity+" - "+ act.getActivity());
            }
            else if (act.getActivity().equals("Swimming"))
            {
                    if (act.EnergyExpended() <= .5)
                    {
                        intesity = "Very Light";
                    } else if (act.EnergyExpended() >.5 &&act.EnergyExpended()<=1.25) {
                        intesity = " Light";
                    }
                    else if (act.EnergyExpended() >1.25 &&act.EnergyExpended()<=2) {
                        intesity = "Moderate";
                    }
                    else if (act.EnergyExpended() >2 &&act.EnergyExpended()<=2.75) {
                        intesity = "Vigorous";
                    }
                    else if (act.EnergyExpended() >2.5 &&act.EnergyExpended()<=3.5) {
                        intesity = "Very Vigorous";
                    }
                    else {
                        System.out.println("Should not exist"+" - "+ act.getActivity());
                    }
                    System.out.println(intesity+" - "+ act.getActivity());
            }


        }
    }

    private static void CaloriesBurned(ArrayList<Activity> activities) {
        for (Activity act: activities)
        {
            if (act.getActivity().equals("Running"))
            {
                if (act.EnergyExpended()*act.getDuration()<= 4)
                {
                    System.out.println(act.EnergyExpended());
                }
            }
            else if(act.getActivity().equals("Swimming"))
            {

            }
            else if(act.getActivity().equals("Cycling"))
            {

            }
            else
            {
                System.out.println("Not included in the list of activities!!!");
            }
        }

    }








    //All to do with reading and display *Tab has 4 characters in it

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
