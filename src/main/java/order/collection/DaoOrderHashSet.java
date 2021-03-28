package order.collection;

import dao.BookingDAO;
import Database.Database;
import order.Order;

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
        return db;
    }

    @Override
    public void cancelOrder(Order order) {
        db.remove(order);
    }


}
