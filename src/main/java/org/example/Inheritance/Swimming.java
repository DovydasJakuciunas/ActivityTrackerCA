package org.example.Inheritance;

import org.example.Activity;

import java.util.ArrayList;

public class Swimming extends Activity{
    private final ArrayList<Activity> activity;

    public Swimming(ArrayList<Activity> activities) {
        this.activity = activities;

    }

    @Override
    public double averageDistancePerActivity() {
        double totalDistance = 0;
        int count = 0;
        for (Activity act: activity)
        {
            if (act.getActivity().equals("Swimming"))
            {
                totalDistance += act.getKilometer();
                count++;
            }
        }


        return totalDistance/count;
    }
}
