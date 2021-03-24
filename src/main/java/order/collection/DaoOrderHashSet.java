package order.collection;

import dao.BookingDAO;
import dao.Database;
import dao.Identifiable;
import order.Order;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class DaoOrderHashSet implements BookingDAO<Order> {
    private Set<Order> db;

    public DaoOrderHashSet(){
        db = Database.getOrdersList();
    }
    
    @Override
    public void saveOrder(Order o) {
        db.add(o);
    }

    @Override
    public Set<Order> getAll() {
        if (!db.isEmpty()) return db;
        else return null;
    }

    @Override
    public void cancelOrder(int id) {
        Optional<Order> gotFlight = db.stream().filter(x -> x.id == id).findFirst();
        if (gotFlight.isPresent()) {
            db.remove(gotFlight);
        }
    }


}
