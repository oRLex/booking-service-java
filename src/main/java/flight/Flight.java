package flight;

import dao.Identifiable;
import utils.Airports;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Flight extends Identifiable implements Serializable {
    static DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

    public static String prettyDate(LocalDateTime t){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = t.format(formatter);
        return formattedDateTime;
    }

    private final Airports from;
    private final Airports to;
    private final LocalDateTime departureTime;
    private final LocalDateTime arrivalTime;
    private final int capacity;
    private final int reservedSeats;

    public Flight(int id, Airports from, Airports to, LocalDateTime departureTime, LocalDateTime arrivalTime, int capacity, int reservedSeats) {
        super(id);
        this.from = from;
        this.to = to;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.capacity = capacity;
        this.reservedSeats = reservedSeats;
    }

    public Airports getFrom() {
        return from;
    }

    public Airports getTo() {
        return to;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public int getFreeSeats(){
        return capacity - reservedSeats;
    }


    @Override
    public String toString() {
        return String.format("ID: %d From: '%s', To: '%s', Departure time: %s, Arrival time: %s, capacity: %d, Reserved seats: %d",
                id,
                from.getTitle(),
                to.getTitle(),
                prettyDate(departureTime),
                prettyDate(arrivalTime),
                capacity,
                reservedSeats);
    }
}
