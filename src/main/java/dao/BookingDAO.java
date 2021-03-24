package dao;

import order.Order;

import java.util.List;
import java.util.Set;

public interface BookingDAO<Order> {
    void saveOrder(Order o);
    Set<Order> getAll();
    void cancelOrder(int id);
}
