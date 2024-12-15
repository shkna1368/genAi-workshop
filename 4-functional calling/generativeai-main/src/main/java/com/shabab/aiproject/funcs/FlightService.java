package com.shabab.aiproject.funcs;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class FlightService {

    private static final Map<Integer,Flight> flights = new ConcurrentHashMap<>();

    static {
        flights.put(1, new Flight("Sanandaj","NY",2000,"2024-12-25 t 18:30"));
        flights.put(2, new Flight("Sanandaj","NY",2000,"2024-12-25 t 20"));
        flights.put(3, new Flight("Sanandaj","Washington",2200,"2024-12-25 t 18:30"));
        flights.put(4, new Flight("Sanandaj","Singapore",1600,"2024-12-25 t 19:30"));
        flights.put(5, new Flight("Sanandaj","frankfort",1000,"2024-12-25 t 20:30"));

    }

    List<Flight> getFight(FlightSearch flightSearch) {
        return flights.values().stream()
                .filter(flight -> flight.from.equalsIgnoreCase(flightSearch.from) && flight.to.equalsIgnoreCase(flightSearch.to))
                .toList();
    }

    public record Flight(String from, String to,long price,String date) {}
    public record FlightSearch(String from, String to) {}

}