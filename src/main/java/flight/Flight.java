package flight;

import dao.Identifiable;

import java.time.LocalDate;

public class Flight  extends Identifiable {
    private final String from;
    private final String to;
    private final LocalDate departureTime;
    private final LocalDate arrivalTime;
    private final int capacity;
    private final int reservedSeats;

    protected Flight(int id, String from, String to, LocalDate departureTime, LocalDate arrivalTime, int capacity, int reservedSeats) {
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

    public LocalDate getDepartureTime() {
        return departureTime;
    }

    public int getFreeSteats(){
        return capacity - reservedSeats;
    }

}
