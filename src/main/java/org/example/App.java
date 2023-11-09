package org.example;

import org.example.Inheritance.Cycling;
import org.example.Inheritance.Running;
import org.example.Inheritance.Swimming;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;

public class App
{

    public static void main( String[] args ) throws FileNotFoundException, ParseException {
        ArrayList<Activity> activities = new ArrayList<>();
        readFile("activity_data_10.csv", activities);


        MainMenu(activities);
    }

    private static void MainMenu(ArrayList<Activity> activities) {

        DisplayMenu menu = new DisplayMenu(activities);
        Running rU = new Running(activities);
        Cycling cY = new Cycling(activities);
        Swimming sW = new Swimming(activities);

        System.out.println(cY.averageDistancePerActivity());
        System.out.println("Welcome to The Best Activity Tracker");
        System.out.println("Please select any of the following options to view your stats");

        int choice = 0;
        do {
            Scanner kb = new Scanner(System.in);


            printMenu(choice);
            choice = kb.nextInt();
            kb.nextLine();

            if (choice ==1)
            {
                do {
                    System.out.println(spacesStart());

                    basicMenu();
                    int subChoice = kb.nextInt();
                    kb.nextLine();

                    System.out.println(spacesStart());

                    userChoiceBasic(subChoice, menu, kb);
                    if (subChoice == 0)
                    {
                        break;

                    }
                    System.out.println(spacesEnd());

                }while (true);
            }
            else if (choice ==2)
            {
                do {
                    System.out.println(spacesStart());

                    subsetMenu();
                    int subChoice = kb.nextInt();
                    kb.nextLine();

                    System.out.println(spacesStart());

                    userSubset(subChoice, menu, kb);
                    if (subChoice == 0)
                    {
                        printMenu(choice);
                        break;
                    }
                    System.out.println(spacesEnd());

                }while (true);
            }
            else if (choice==3)
            {
                do {
                    System.out.println(spacesStart());

                    specificActivityMenu();
                    int subChoice = kb.nextInt();

                    System.out.println(spacesStart());

                    specificActivity(subChoice,activities);
                    if (subChoice == 0)
                    {
                        break;

                    }

                    System.out.println(spacesEnd());

                }while (true);
            }
            else if (choice ==4)
            {
                do {
                    System.out.println(spacesStart());

                    overallPerformanceMenu();
                    int subChoice = kb.nextInt();
                    kb.nextLine();

                    System.out.println(spacesStart());

                    userPerformance(subChoice, cY,rU,sW);
                    if (subChoice == 0)
                    {

                        break;
                    }
                    System.out.println(spacesEnd());

                }while (true);
            }

            System.out.println(spacesEnd());
        }
        while(choice!=0);
    }



    private static void printMenu(int choice) {
        System.out.printf("%-3d- %-18s\n", 0, "Exit");
        System.out.printf("%-3d- %-18s\n", 1, "Basic Menu");
        System.out.printf("%-3d- %-18s\n", 2, "Subset Menu");
        System.out.printf("%-3d- %-18s\n", 3, "Specific Activity");
        System.out.printf("%-3d- %-18s\n", 4, "Overall Performance ");
        if (choice ==1)
        {
            basicMenu();
        }
        else if (choice == 2 )
        {
            subsetMenu();
        }
        else if (choice == 3)
        {
            specificActivityMenu();
        }
        else if (choice == 4)
        {
            overallPerformanceMenu();
        }


    }

    private static void basicMenu() {
        System.out.printf("%-3d- %-18s\n", 0, "Exit");
        System.out.printf("%-3d- %-18s\n", 1, "Calories Burned");
        System.out.printf("%-3d- %-18s\n", 2, "Date Ascending Order");
        System.out.printf("%-3d- %-18s\n", 3, "Date Descending Order");
        System.out.printf("%-3d- %-18s\n", 4, "Activity Duration Ascending Order");
        System.out.printf("%-3d- %-18s\n", 5, "Activity Duration Descending Order");
        System.out.printf("%-3d- %-18s\n", 6, "Type of Activity");
        System.out.printf("%-3d- %-18s\n", 7, "Distance Ascending Order");
        System.out.printf("%-3d- %-18s\n", 8, "Distance Descending Order");
    }
    private static void userChoiceBasic(int choice, DisplayMenu menu, Scanner kb) {
        if(choice ==1)
        {
            CaloriesBurned();
        }
        else if(choice ==2)
        {
            menu.displayDateAscending();
        }
        else if(choice ==3)
        {
            menu.displayDateDescending();
        }
        else if(choice ==4)
        {
            menu.displayDurationAscending();
        }
        else if(choice ==5)
        {
            menu.displayDurationDescending();
        }
        else if(choice ==6)
        {
            menu.displayTypeOfActivity();
        }
        else if(choice ==7)
        {
            menu.displayDistanceAscending();
        }
        else if(choice ==8)
        {
            menu.displayDistanceDescending();
        }
    }

    private static void subsetMenu() {
        System.out.println(spacesStart());
        System.out.println("You have selected subset of the activities");
        System.out.println("Please choose from the following options");

        System.out.printf("%-3d- %-18s\n", 0, "Exit");
        System.out.printf("%-3d- %-18s\n", 1, "Activity Type");
        System.out.printf("%-3d- %-18s\n", 2, "Above a Minimum Distance in Kilometers");
        System.out.printf("%-3d- %-18s\n", 3, "Type of Energy Expended");
        System.out.printf("%-3d- %-18s\n", 4, "Above a Minimum Duration");
        System.out.println(spacesEnd());

    }
    private static void userSubset(int subChoice, DisplayMenu menu, Scanner kb) {
        if (subChoice == 1)
        {
            menu.displayOnlyActivity(kb);
        }
        else if (subChoice == 2)
        {
            menu.displayAboveMinimumDistance(kb);
        }
        else if (subChoice == 3)
        {
            menu.displayTypeOfEnergyExpended();
        }
        else if (subChoice == 4)
        {
            menu.displayAboveMinimumDuration(kb);
        }
        System.out.println(spacesEnd());

    }


    private static void overallPerformanceMenu() {
        System.out.println("From the following options, please select one");
        System.out.printf("%-3d- %-18s\n", 0, "Exit");
        System.out.printf("%-3d- %-18s\n", 1, "Average distance for Running");
        System.out.printf("%-3d- %-18s\n", 2, "Average distance for Cycling");
        System.out.printf("%-3d- %-18s\n", 3, "Average distance for Swimming");
        System.out.printf("%-3d- %-18s\n", 4, "Calories Burned");
    }
    private static void userPerformance(int subChoice, Cycling cycling ,Running ran,Swimming swam) {
        if (subChoice == 1)
        {
            System.out.printf("%15s %3.2f m\n", "The amount you ran is =",ran.averageDistancePerActivity());
        }
        else if (subChoice == 2)
        {
            System.out.printf("%15s %3.2f m\n", "The amount you cycled is =",cycling.averageDistancePerActivity());
        }
        else if (subChoice == 3)
        {
            System.out.printf("%15s %3.2f m\n", "The amount you swam is =",swam.averageDistancePerActivity());
        } else if (subChoice == 4) {
            System.out.println("App is suffering malfunctions, sorry for inconvenience");
        }
    }



    private static void specificActivityMenu()
    {
        System.out.println("Please enter the activity you want to view");
        System.out.printf("%-3d- %-18s\n", 0, "Exit");
        System.out.printf("%-3d- %-18s\n", 1, "Running");
        System.out.printf("%-3d- %-18s\n", 2, "Cycling");
        System.out.printf("%-3d- %-18s\n", 3, "Swimming");

    }
    private static void specificActivity(int subChoice ,ArrayList<Activity> activities) {

       if (subChoice==1)
       {
           for (Activity act: activities)
           {
                if (act.getActivity().equals("Running"))
                {
                     System.out.printf("%-15s %-11s %-10d %-10.2f %-5d\n", act.getActivity(), act.getDate(), act.getDuration(), act.getKilometer(), act.getAverageHeartRate());
                }
           }
       }
       else if (subChoice==2)
       {
           for (Activity act: activities)
           {
               if (act.getActivity().equals("Cycling"))
               {
                   System.out.printf("%-15s %-11s %-10d %-10.2f %-5d\n", act.getActivity(), act.getDate(), act.getDuration(), act.getKilometer(), act.getAverageHeartRate());
               }
           }
       }
       else if(subChoice==3)
       {
           for (Activity act: activities)
           {
               if (act.getActivity().equals("Swimming"))
               {
                   System.out.printf("%-15s %-11s %-10d %-10.2f %-5d\n", act.getActivity(), act.getDate(), act.getDuration(), act.getKilometer(), act.getAverageHeartRate());
               }
           }
       }
       else {
           System.out.println("Sorry no such activity exists in the table.");
       }

    }

    private static String spacesStart(){

        return "\n***************************************************************";
    }
    private static String spacesEnd(){

        return "***************************************************************\n";
    }

    /*The no-go zone
    public static void Intensity(ArrayList<Activity> activities)
    {
        String intensity = null;
        for (Activity act: activities)
        {
            switch (act.getActivity()) {
                case "Running":
                    if (act.EnergyExpended() <= 4) {
                        intensity = "Very Light";
                    } else if (act.EnergyExpended() > 4 && act.EnergyExpended() <= 8) {
                        intensity = " Light";
                    } else if (act.EnergyExpended() > 8 && act.EnergyExpended() <= 12) {
                        intensity = "Moderate";
                    } else if (act.EnergyExpended() > 12 && act.EnergyExpended() <= 16) {
                        intensity = "Vigorous";
                    } else if (act.EnergyExpended() > 16 && act.EnergyExpended() <= 24) {
                        intensity = "Very Vigorous";
                    } else {
                        System.out.println("Should not exist" + " - " + act.getActivity());
                    }
                    System.out.println(intensity + " - " + act.getActivity());
                    break;
                case "Cycling":
                    if (act.EnergyExpended() <= 8) {
                        intensity = "Very Light";
                    } else if (act.EnergyExpended() > 8 && act.EnergyExpended() <= 16) {
                        intensity = " Light";
                    } else if (act.EnergyExpended() > 17 && act.EnergyExpended() <= 25) {
                        intensity = "Moderate";
                    } else if (act.EnergyExpended() > 25 && act.EnergyExpended() <= 33) {
                        intensity = "Vigorous";
                    } else if (act.EnergyExpended() > 33 && act.EnergyExpended() <= 40) {
                        intensity = "Very Vigorous";
                    } else {
                        System.out.println("Should not exist" + " - " + act.getActivity());
                    }
                    System.out.println(intensity + " - " + act.getActivity());
                    break;
                case "Swimming":
                    if (act.EnergyExpended() <= .5) {
                        intensity = "Very Light";
                    } else if (act.EnergyExpended() > .5 && act.EnergyExpended() <= 1.25) {
                        intensity = " Light";
                    } else if (act.EnergyExpended() > 1.25 && act.EnergyExpended() <= 2) {
                        intensity = "Moderate";
                    } else if (act.EnergyExpended() > 2 && act.EnergyExpended() <= 2.75) {
                        intensity = "Vigorous";
                    } else if (act.EnergyExpended() > 2.5 && act.EnergyExpended() <= 3.5) {
                        intensity = "Very Vigorous";
                    } else {
                        System.out.println("Should not exist" + " - " + act.getActivity());
                    }
                    System.out.println(intensity + " - " + act.getActivity());
                    break;
            }


        }
    }
    */
    private static void CaloriesBurned() {
        System.out.println("App is suffering malfunctions, sorry for inconvenience");
//        for (Activity act: activities)
//        {
//            if (act.getActivity().equals("Running"))
//            {
//                if (act.EnergyExpended()*act.getDuration()<= 4)
//                {
//                    System.out.println(act.EnergyExpended());
//                }
//            }
//            else if(act.getActivity().equals("Swimming"))
//            {
//
//            }
//            else if(act.getActivity().equals("Cycling"))
//            {
//
//            }
//            else
//            {
//                System.out.println("Not included in the list of activities!!!");
//            }
//        }
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
        //String[] dates = dateStr.split("/");
        //date = new Date(Integer.parseInt(dates[2])-1900,Integer.parseInt(dates[1])-1,Integer.parseInt(dates[0]));
        date = DateFormat.getDateInstance(DateFormat.SHORT, Locale.UK).parse(dateStr);

        duration = Integer.parseInt(act.nextToken().trim());

        kilometer = Double.parseDouble(act.nextToken().trim());

        averageHeartRate = Integer.parseInt(act.nextToken().trim());

        return new Activity(activity,duration,date,kilometer,averageHeartRate);


    }
}
