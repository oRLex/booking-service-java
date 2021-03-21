package flight;

import dao.Identifiable;

import java.time.LocalDateTime;

public class Flight  extends Identifiable {
    private final String from;
    private final String to;
    private final LocalDateTime departureTime;
    private final LocalDateTime arrivalTime;
    private final int capacity;
    private final int reservedSeats;

    public Flight(int id, String from, String to, LocalDateTime departureTime, LocalDateTime arrivalTime, int capacity, int reservedSeats) {
        super(id);
        this.from = from;
        this.to = to;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.capacity = capacity;
        this.reservedSeats = reservedSeats;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public int getFreeSeats(){
        return capacity - reservedSeats;
    }

}
