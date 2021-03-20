package order.service;

import dao.BookingDAO;
import dao.Identifiable;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class OrderService<T extends Identifiable> implements BookingDAO<T> {
    private final Set<T> db = new HashSet<>();

    @Override
    public void saveOrder(T o) {
        db.add(o);
    }

    @Override
    public Set<T> searchOrder() {
        if (!db.isEmpty()) return db;
        else return null;
    }

    @Override
    public void cancelOrder(int id) {
        Optional<T> gotFlight = db.stream().filter(x -> x.id == id).findFirst();
        if (gotFlight.isPresent()) {
            db.remove(gotFlight);
        }
    }
}
