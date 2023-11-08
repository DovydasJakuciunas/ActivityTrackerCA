package org.example;

import org.example.Inheritance.Running;

import java.util.Date;

public class Activity
{

    //Create a method that calculates the calories burned for a given activity
    //Using average heart rate, duration and the method EnergyExpanded()
    //Create a method that calculates the intensity of the activity
    public String Intensity()
    {
        String intesity = null;
        if (this.activity.equals("Running"))
        {
            case 0:
                intesity = VERY_LIGHT;
        }
        return intesity;
    }





    enum activeType{RUNNING,CYCLING,SWIMMING};
    enum intensityOfActivity{VERY_LIGHT,LIGHT,MODERATE,VIGOROUS,VERY_VIGOROUS};

    String activity;
    int duration;
    Date date;
    double kilometer;
    int averageHeartRate;
    double energyBurned;

    public Activity(String activity, int duration, Date date, double kilometer, int averageHeartRate) {
        this.activity = activity;
        this.duration = duration;
        this.date = date;
        this.kilometer = kilometer;
        this.averageHeartRate = averageHeartRate;
    }
    public Activity(){};
    public double EnergyExpended()
    {
        return energyBurned = kilometer*100/duration;
    }
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

}
