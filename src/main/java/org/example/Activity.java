package org.example;

public class Activity
{
    String activity;
    int duration;
    long date;
    double kilometer;
    int averageHeartRate;

    public Activity(String activity, int duration, long date, double kilometer, int averageHeartRate) {
        this.activity = activity;
        this.duration = duration;
        this.date = date;
        this.kilometer = kilometer;
        this.averageHeartRate = averageHeartRate;
    }

    //Getters
    public String getActivity() {
        return activity;
    }
    public int getDuration() {
        return duration;
    }
    public long getDate() {
        return date;
    }
    public double getKilometer() {
        return kilometer;
    }
    public int getAverageHeartRate() {
        return averageHeartRate;
    }

    //Setters
}
