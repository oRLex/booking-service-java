package flight.service;

import dao.FlightsDAO;
import flight.Flight;
import flight.collection.DaoFlightHashSet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class FlightService{

    private FlightsDAO dao = new DaoFlightHashSet();

    public FlightService(){

    }

    public Set<Flight> getAll(){return dao.getAll();}

    public String getAll(Set<Flight> fts){
        StringBuilder strb = new StringBuilder();
        for(Flight f: fts){
            strb.append(f);
            strb.append("\n");
        }
        return strb.toString();
    }


    public Set<Flight> getFlight(String destination, String data, int ticketsNumber){
        LocalDate parsedUserData = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/M/yyyy"));
        Set<Flight> flights = dao.getAll();
        Set<Flight> collect = flights.stream().filter(x -> x.getTo().equalsIgnoreCase(destination) && x.getDepartureTime().equals(parsedUserData) && x.getFreeSeats() >= ticketsNumber).collect(Collectors.toSet());
        return collect;
    }

    public Optional<Flight> getFlightByIndex(int index){
        Optional<Flight> flights = dao.getFlight(index);
        return flights;
    }

}
