package flight.service;

import dao.FlightsDAO;
import flight.Flight;
import flight.collection.DaoFlightHashSet;
import utils.RandomFlights;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.stream.Collectors;

public class FlightService{

    private FlightsDAO dao = new DaoFlightHashSet();

    public FlightService(){

    }

    public String getAll(){
        Set<Flight> all = dao.getAll();
        StringBuilder strb = new StringBuilder();
        for(Flight f: all){
            strb.append(f);
            strb.append("\n");
        }
        return strb.toString();
    }


    public Set<Flight> getFlight(String destination, String data, int ticketsNumber){
        LocalDateTime parsedUserData = LocalDateTime.parse(data, DateTimeFormatter.ofPattern("dd/M/yyyy"));
        Set<Flight> flights = dao.getAll();
        return flights.stream().filter(x -> x.getTo().toString() == destination && x.getDepartureTime() == parsedUserData && x.getFreeSeats() >= ticketsNumber).collect(Collectors.toSet());
    }

}
