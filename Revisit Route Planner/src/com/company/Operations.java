package com.company;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Operations {
    ArrayList<Route> list = new ArrayList<>();
    public List<Route> display_file() throws IOException {
        File f = new File("D:\\Vaishnavi\\NIIT\\Course5\\C5S6Project1 Revisit Route Planner\\src\\com\\company\\routes.csv");
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            int i = 0;
            String temp;
            while ((temp = br.readLine()) != null) {
                String[] tempArray = temp.split(",");
                int distance = Integer.parseInt(tempArray[2].trim());
                list.add(new Route(tempArray[0], tempArray[1], distance, tempArray[3], tempArray[4]));
                i++;
            }
        }
        System.out.println("\t\t\t From\t\t\t\t  To\t\t\t\tDistance in km\t\tTravel Time\t\t\tTypical Airfare\n");
        list.forEach(x -> System.out.println(x));
        return list;
    }

    public List<Route> showDirectFlights(List<Route> list,String fromCity){
        List<Route> routeDetails=list.stream().filter(i->i.getSource().equalsIgnoreCase(fromCity)).map(i->i).collect(Collectors.toList());
        System.out.println("\t\t From\t\t\t\t To\t\t\t\tDistance in km\t\t\tTravel Time\t\t\t\tTypical Airfare \n");
        routeDetails.forEach(x->System.out.println(x));
        return routeDetails;
    }

    public void sortDirectFlights(List<Route> list,String fromCity)
    {
        System.out.println("\t\t From\t\t\t\t\tTo\t\t\t\tDistance in km\t\tTravel Time\t\t\t\tTypical Airfare \n");
        List<Route> routeDetails=list.stream().filter(i->i.getSource().equalsIgnoreCase(fromCity)).sorted(Comparator.comparing(Route::getDestination)).map(i->i).collect(Collectors.toList());
        routeDetails.forEach(x->System.out.println(x));
    }

    public void showAllConnections(List<Route> list,String fromCity,String toCity) throws NoSuchFieldException
    {
        AtomicInteger count = new AtomicInteger();
        int count1 = 0;
        list.stream().filter(x->x.getSource().trim().equals(fromCity.trim())).filter(j->j.getDestination().trim().equals(toCity.trim())).forEach(i-> System.out.println(i+"\n"));
        list.stream().filter(x->x.getSource().trim().equals(fromCity.trim())).filter(j->j.destination.trim().equals(toCity.trim())).forEach(x->count.set(count.get()+1));
        if((count.get() ==0) && (count.get()!=0))
        {
            throw new NoSuchFieldException("We are sorry. At this point of time, we do not have any information on flights between "+fromCity+" and "+toCity);
        }


        for (Route x : list) {
            String intermediate = x.destination.trim();
            if (x.getSource().trim().equals(fromCity) && x.destination.trim().equals(intermediate.trim())) {

                for (Route y : list) {
                    if (intermediate.trim().equals(y.getSource().trim()) && y.destination.trim().equals(toCity.trim())) {

                        if (y.getSource().trim().equals(intermediate.trim())) {

                            count1++;

                            System.out.println(x);
                            System.out.println(y+"\n");
                        }
                    }
                }
            }

        }
    }
}