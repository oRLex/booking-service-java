package flight.service;

import dao.FlightsDAO;
import flight.Flight;
import flight.collection.DaoFlightHashSet;
import utils.RandomFlights;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Set;

public class FlightService{
    private FlightsDAO<Flight> dao = new DaoFlightHashSet<>();
    RandomFlights randomFlights = new RandomFlights();

    public FlightService(){
        dao.create(randomFlights.generateFlights());
    }

    public Set<Flight> getAll(){
        return dao.getAll();
    }

    public Optional<Flight> getFlight(String destination, String data, int ticketsNumber){

        /*
        convert from LocalDateTime to LocalDate
         */
        LocalDateTime parsedUserData = LocalDateTime.parse(data, DateTimeFormatter.ofPattern("dd/M/yyyy"));
        Set<Flight> flights = dao.getAll();
        return flights.stream().filter(x -> x.getTo() == destination && x.getDepartureTime() == parsedUserData && x.getFreeSeats() >= ticketsNumber).findFirst();
    }

}
