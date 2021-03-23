package flight.controller;


import flight.Flight;
import flight.service.FlightService;

public class FlightController {
    public final  FlightService flightService = new FlightService();

    public String showAll(){
        return  flightService.getAll();
    }



}
