package org.example;


import java.util.Date;

public class Activity
{

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

    public double EnergyExpended()
    {
        return energyBurned = kilometer*100/duration;
    }

    public double averageDistancePerActivity()
    {
        return kilometer/duration;
    }





}
