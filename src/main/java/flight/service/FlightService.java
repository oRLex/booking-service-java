package flight.service;

import dao.FlightsDAO;
import flight.Flight;
import flight.collection.DaoFlightHashSet;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Set;

public class FlightService{
    private FlightsDAO<Flight> dao = new DaoFlightHashSet<>();

    public Set<Flight> getAll(){
        return dao.getAll();
    }

    public Optional<Flight> getFlight(String destination, String data, int ticketsNumber){
        LocalDate parsedUserData = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/M/yyyy"));
        Set<Flight> flights = dao.getAll();
        return flights.stream().filter(x -> x.getTo() == destination && x.getDepartureTime() == parsedUserData && x.getFreeSteats() >= ticketsNumber).findFirst();
    }

}
