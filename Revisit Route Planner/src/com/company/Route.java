package com.company;

public class Route {
    String source, destination,flight_time;
    long distance; String ticket_cost;

    public Route(String source, String destination, long distance, String flight_time, String ticket_cost) {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.flight_time = flight_time;
        this.ticket_cost = ticket_cost;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public String getFlight_time() {
        return flight_time;
    }

    public void setFlight_time(String flight_time) {
        this.flight_time = flight_time;
    }

    public String getTicket_cost() {
        return ticket_cost;
    }

    public void setTicket_cost(String ticket_cost) {
        this.ticket_cost = ticket_cost;
    }

    // @Override
    public String toString() {
        return (String.format("%16s %18s %19s %20s %24s",source,destination,distance,flight_time,ticket_cost));
    }


}

