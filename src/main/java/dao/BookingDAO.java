package dao;

import order.Order;

import java.util.List;
import java.util.Set;

public interface BookingDAO<T> {
    void saveOrder(T o);
    List<T> searchOrder();
    void cancelOrder(int id);
}
