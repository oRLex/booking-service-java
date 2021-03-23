package flight.controller;


import flight.Flight;
import flight.service.FlightService;

import java.util.Optional;
import java.util.Set;

public class FlightController {
    private final  FlightService flightService = new FlightService();

    public Set<Flight> getAll(){
        return flightService.getAll();
    }

    public Optional<Flight> getFlightByIndex(Integer idFlight) {
        Optional<Flight> flight = flightService.getFlightByIndex(idFlight);
        return flight;
    }

    public String getFlight(String destination, String data, int ticketsNumber){
        Set<Flight> flight = flightService.getFlight(destination, data, ticketsNumber);
        return flightService.getAll(flight);
    }


}
