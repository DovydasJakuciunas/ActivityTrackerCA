package org.example.Inheritance;

import org.example.Activity;

import java.util.ArrayList;

public class Cycling extends Activity
{
    private final ArrayList<Activity> activity;

    public Cycling(ArrayList<Activity> activities) {
        this.activity = activities;

    }

    @Override
    public double averageDistancePerActivity() {
        double totalDistance = 0;
        int count = 0;
        for (Activity act: activity)
        {

            if (act.getActivity().equals("Cycling"))
            {
                totalDistance += act.getKilometer();
                count++;
            }
        }
                totalDistance = totalDistance/count;
        return totalDistance;
    }





}
