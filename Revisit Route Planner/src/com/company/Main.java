package com.company;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException, NoSuchFieldException {
        Scanner s=new Scanner(System.in);
        Operations operations=new Operations();
        System.out.println("*******************************************ALL FLIGHT DETAILS********************************************\n");
        List<Route> list = operations.display_file();
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println("\n**************************************FLIGHTS FROM YOUR CITY******************************************\n");
        System.out.print("\nENTER THE CITY TO CHECK THE FLIGHT DETAILS : ");
        String city=s.nextLine();
        List<Route> showDirectFlights=operations.showDirectFlights(list,city);
        System.out.println("\n*************************************FLIGHT DETAILS AFTER SORTING**************************************\n");
        operations.sortDirectFlights(list,city);
        System.out.println("\n---------------------------------------------------------------------------------------------------------");
        System.out.print("Enter Source City Name : ");
        String Fromcity = s.nextLine();
        System.out.print("Enter Destination City Name : ");
        String Tocity = s.nextLine();
        System.out.println(String.format("%15s %15s %25s %20s %20s", "From", "To", "Distance in Km", "Travel Time", "Typical Airfare"));
        operations.showAllConnections(list, Fromcity,Tocity);

    }
}