package utils;

import flight.Flight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class RandomFlights {
    public int randomInt(int min, int max){
        return (int)(Math.floor(Math.random() * (max - min + 1)) + min);
    }

    public Set<Flight> generateFlights(){
        Set<Flight> flights = new HashSet<>();
        String from, to;
        LocalDateTime departureTime, arrivalTime;
        int capacity, reservedSeats;
        for (int i =0; i < 100; i++){
            from = "Kyiv";
            do {
                to = generateAirport();
            } while (from.equals(to));
            departureTime = generateDepartureTime();
            arrivalTime = generateArrivalTime(departureTime);
            capacity = randomInt(10,100);
            reservedSeats = randomInt(0,capacity);
            flights.add(new Flight(i,from,to,departureTime,arrivalTime,capacity,reservedSeats));
        }
        return flights;
    }

    public LocalDateTime generateDepartureTime(){
        long tomorrow = LocalDate.now().plusDays(1).toEpochDay();
        return LocalDateTime.of(LocalDate.ofEpochDay(tomorrow), LocalTime.of(randomInt(0,23),randomInt(0,59)));
    }

    public String generateAirport(){
        Airports[] values = Airports.values();
        Airports value = values[randomInt(0, values.length - 1)];
        return value.name();
    }

    public LocalDateTime generateArrivalTime(LocalDateTime departureTime){
        LocalDate nextDay = departureTime.plusDays(1).toLocalDate();
        return LocalDateTime.of(nextDay, LocalTime.of(randomInt(0, 23), randomInt(0, 59)));
    }

}
