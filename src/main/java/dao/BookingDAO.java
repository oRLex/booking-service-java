package dao;

import java.util.Set;

public interface BookingDAO<Order> {
    void saveOrder(Order o);
    Set<Order> getAll();
    void cancelOrder(Order o);
}
