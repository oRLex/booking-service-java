package order.controller;

import flight.Flight;
import order.Order;
import order.service.OrderService;
import person.Person;

import java.util.Set;

public class OrderController {
    public final OrderService orderService = new OrderService();

    public OrderController() {}

    public void addOrder(String name, String surname, Flight flight){
        Person person = new Person(name, surname);
        Order order = new Order(person, flight, orderService.getAll().size()+1);
        orderService.saveOrder(order);
    }

    public void cancelOrder(int id){
            orderService.cancelOrder(id);
    }

    public Set<Order> searchOrderUser(String name, String surname){
        Set<Order> orders = orderService.searchOrder(name, surname);
        return orders;
    }

    public Set<Order> getAll(){
        return orderService.getAll();
    }

}
