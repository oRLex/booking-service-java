package order;

import dao.Identifiable;
import flight.Flight;
import person.Person;

public class Order extends Identifiable {
    private final Flight f;
    private final Person p;

    public Order(int id, Flight f, Person p) {
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
}
