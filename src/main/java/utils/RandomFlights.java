package utils;

import flight.Flight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class RandomFlights {
    public int randomInt(int min, int max){
        return (int)(Math.floor(Math.random() * (max - min + 1)) + min);
    }

    public Set<Flight> generateFlights(){
        Set<Flight> flights = new HashSet<>();
        Airports from, to;
        LocalDateTime departureTime, arrivalTime;
        int capacity, reservedSeats;
        for (int i =0; i < 100; i++){
            from = Airports.KBP;
            do {
                to = Airports.getRandom();
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
        long now = LocalDate.now().toEpochDay();
        long daysAfter = LocalDate.now().plusDays(30).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(now, daysAfter);

        return LocalDateTime.of(LocalDate.ofEpochDay(randomDay), LocalTime.of(randomInt(0,23),randomInt(0,59)));
    }

    public String generateAirport(){
        Airports[] values = Airports.values();
        Airports value = values[randomInt(0, values.length - 1)];
        return String.valueOf(value);
    }

    public LocalDateTime generateArrivalTime(LocalDateTime departureTime){
        LocalDate nextDay = departureTime.plusDays(1).toLocalDate();
        return LocalDateTime.of(nextDay, LocalTime.of(randomInt(0, 23), randomInt(0, 59)));
    }

}
