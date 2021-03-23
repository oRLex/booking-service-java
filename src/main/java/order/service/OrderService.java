package order.service;

import dao.BookingDAO;
import dao.FlightsDAO;
import dao.Identifiable;
import flight.collection.DaoFlightHashSet;
import order.Order;
import order.collection.DaoOrderHashSet;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderService {
    private BookingDAO dao = new DaoOrderHashSet();
    public OrderService(){

    }

    public void saveOrder(Order o) {
        dao.saveOrder(o);
    }

    public Set<Order> searchOrder(String name, String surname) {
        Set<Order> orders = dao.getAll();
        return  orders.stream()
                .filter(x ->  x.getPeron().name.equalsIgnoreCase(name) && x.getPeron().surname.equalsIgnoreCase(surname))
                .collect(Collectors.toSet());
    }

    public void cancelOrder(int id) {
        Set<Order> orders = dao.getAll();
        Optional<Order> gotFlight = orders.stream().filter(x -> x.id == id).findFirst();
        if (gotFlight.isPresent()) {
            dao.cancelOrder(gotFlight.get().id);
        }
    }
}
