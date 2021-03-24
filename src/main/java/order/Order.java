package order;
import dao.Identifiable;
import flight.Flight;
import person.Person;

import java.io.Serializable;

public class Order extends Identifiable implements Serializable {
    private final Flight f;
    private final Person p;

    public Order(Person p, Flight f, int id) {
        super(id);
        this.f = f;
        this.p = p;
    }

    public Flight getFLight() {
        return f;
    }

    public Person getPeron() {
        return p;
    }

    @Override
    public String toString() {
        return String.format("Order: flight: %s, Person: %s}", f, p);
    }
}
