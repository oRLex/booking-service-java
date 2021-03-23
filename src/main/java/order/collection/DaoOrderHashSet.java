package order.collection;

import dao.BookingDAO;
import dao.Identifiable;
import order.Database;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


public class DaoOrderHashSet<T extends Identifiable> implements BookingDAO<T> {
    public final List<T> db = (List<T>) Database.getOrdersList();
    
    @Override
    public void saveOrder(T o) {
        db.add(o);
    }

    @Override
    public List<T> searchOrder() {
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
