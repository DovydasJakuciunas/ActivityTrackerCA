package org.example;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;

public class DisplayMenu
{
    private final ArrayList<Activity> activity;

    public DisplayMenu(ArrayList<Activity> activities) {
        this.activity = activities;

    }


    //Basic Menu******************************************************************
    public void display(){
        System.out.printf("%-15s %-11s %-10s %-10s %-20s\n","Activity Type","Date","Duration","Distance","Average Heart Rate");
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        for (Activity act: activity)
        {
            System.out.printf("%-15s %-11s %-10d %-10.2f %-5d\n", act.getActivity(), df.format(act.getDate()), act.getDuration(), act.getKilometer(), act.getAverageHeartRate());
        }
    }

    public void displayDateAscending() //Sorted using Comparator
    {

        Collections.sort(activity, new Comparator<Activity>()
        {
            @Override
            public int compare(Activity o1, Activity o2)
            {
                return o1.getDate().compareTo(o2.getDate());
            }
        });

        display();

    }

    public void displayDateDescending(){
        Collections.sort(activity, (o1, o2) -> o2.getDate().compareTo(o1.getDate()));

            display();

    } //Sorted using Lambda

    public void displayDurationAscending(){
        Collections.sort(activity, (o1, o2) -> o1.getDuration() - o2.getDuration());
        display();
    } //Sorted using Lambda

    public void displayDurationDescending(){

        Collections.sort(activity, new Comparator<Activity>() {
            @Override
            public int compare(Activity o1, Activity o2) {
                return o2.getDuration() - o1.getDuration();
            }
        });
        display();
    } //Sorted using Comparator

    public void displayTypeOfActivity(){
        ArrayList<String> typeOfActivity = new ArrayList<String>();
        for (Activity act: activity)
        {
            if (!typeOfActivity.contains(act.getActivity()))
            {
                typeOfActivity.add(act.getActivity());
            }
        }

        for (String type: typeOfActivity)
        {

            System.out.println("Type of Exercise = "+type);
            System.out.printf("%-15s %-11s %-10s %-10s %-20s\n","Activity Type","Date","Duration","Distance","Average Heart Rate");
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            for (Activity act: activity)
            {
                if (act.getActivity().equals(type))
                {
                    System.out.printf("%-15s %-11s %-10d %-10.2f %-5d\n", act.getActivity(), df.format(act.getDate()), act.getDuration(), act.getKilometer(), act.getAverageHeartRate());
                }
            }
        }
    } //Sorted by Type of Activity

    public void displayDistanceAscending() //Sorted using Lambda
    {
        Collections.sort(activity, (o1, o2) -> (int) (o1.getKilometer() - o2.getKilometer()));
        display();
    }

    public void displayDistanceDescending() //Sorted using Lambda
    {
        Collections.sort(activity, ((o1, o2) -> (int) (o2.getKilometer() - o1.getKilometer())));
        display();
    }

    //Subset Menu******************************************************************
    public void displayAboveMinimumDistance(Scanner kb)
    {
        System.out.println("Enter the minimum distance: ");
        double min = kb.nextDouble();

        System.out.printf("%-15s %-11s %-10s %-10s %-20s\n","Activity Type","Date","Duration","Distance","Average Heart Rate");
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        for (Activity act: activity)
        {
            if (act.getKilometer() >= min)
            {
                System.out.printf("%-15s %-11s %-10d %-10.2f %-5d\n", act.getActivity(), df.format(act.getDate()), act.getDuration(), act.getKilometer(), act.getAverageHeartRate());
            }
        }
    }

    public void displayOnlyActivity(Scanner kb)
    {
        System.out.println("Enter the activity: ");
        String userInput = kb.next();
        userInput = userInput.substring(0,1).toUpperCase() + userInput.substring(1).toLowerCase();

        System.out.printf("%-15s %-11s %-10s %-10s %-20s\n","Activity Type","Date","Duration","Distance","Average Heart Rate");
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        for (Activity act: activity)
        {
            if (act.getActivity().equals(userInput))
            {
                System.out.printf("%-15s %-11s %-10d %-10.2f %-5d\n", act.getActivity(), df.format(act.getDate()), act.getDuration(), act.getKilometer(), act.getAverageHeartRate());
            }
            else
            {
                System.out.println("Sorry no such activity exists in the table.");
                break;
            }
        }
    }

    public void displayTypeOfEnergyExpended()
    {
        ArrayList<String> typeEnergy = new ArrayList<String>();
        for (Activity act: activity)
        {
            if (!typeEnergy.contains(act.getActivity()))
            {
                typeEnergy.add(act.getActivity());
            }
        }

        double totalRunning = 0;
        double totalCycling = 0;
        double totalSwimming = 0;
        for (Activity act : activity)
        {
            if (act.getActivity().equals("Running"))
            {
                totalRunning += act.EnergyExpended();
            }
            else if (act.getActivity().equals("Cycling"))
            {
                totalCycling += act.EnergyExpended();
            }
            else if (act.getActivity().equals("Swimming"))
            {
                totalSwimming += act.EnergyExpended();
            }
            else {
                System.out.println("Should not exist" + " - " + act.getActivity());
            }

        }
        System.out.printf("Total Energy Expended for Running = %5.3f Kw\n ", totalRunning);
        System.out.printf("Total Energy Expended for Cycling = %5.3f Kw\n ", totalCycling);
        System.out.printf("Total Energy Expended for Swimming = %5.3f Kw\n ", totalSwimming);






    }

    public void displayAboveMinimumDuration(Scanner kb)
    {
        System.out.println("Enter the minimum  in minutes: ");
        int min = kb.nextInt();

        System.out.printf("%-15s %-11s %-10s %-10s %-20s\n","Activity Type","Date","Duration","Distance","Average Heart Rate");
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        for (Activity act: activity)
        {
            if (act.getDuration() >= min)
            {
                System.out.printf("%-15s %-11s %-10d %-10.2f %-5d\n", act.getActivity(), df.format(act.getDate()), act.getDuration(), act.getKilometer(), act.getAverageHeartRate());
            }
        }

    }
}
