package org.example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Activity
{
    enum ActivitiesType {Running,Swimming,Cycling};
    String activity;
    int duration;
    Date date;
    double kilometer;
    int averageHeartRate;

    public Activity(String activity, int duration, Date date, double kilometer, int averageHeartRate) {
        this.activity = activity;
        this.duration = duration;
        this.date = date;
        this.kilometer = kilometer;
        this.averageHeartRate = averageHeartRate;
    }
    public Activity(){};

    //Getters
    public String getActivity() {
        return activity;
    }
    public int getDuration() {
        return duration;
    }
    public Date getDate() {
        return date;
    }
    public double getKilometer() {
        return kilometer;
    }
    public int getAverageHeartRate() {
        return averageHeartRate;
    }

    //Setters

    @Override
    public String toString() {
        return "Activity{" +
                "activity='" + activity + '\'' +
                ", duration=" + duration +
                ", date=" + date +
                ", kilometer=" + kilometer +
                ", averageHeartRate=" + averageHeartRate +
                '}';
    }


    public void getActivityType()
    {

    }






}
