package dao;

import order.Order;

import java.util.Set;

public interface BookingDAO<T extends Identifiable> {
    void saveOrder(T o);
    Set<T> searchOrder();
    void cancelOrder(int id);
}
