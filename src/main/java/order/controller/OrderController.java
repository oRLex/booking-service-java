package order.controller;

import flight.Flight;
import order.Order;
import order.service.OrderService;
import person.Person;

import java.util.List;
import java.util.stream.Collectors;

public class OrderController {
    public final OrderService<Order> orderService =new OrderService<>();


    public OrderController() {}

    public void addOrder(String name, String surname, Flight flight){
        Person person = new Person(name, surname);
        Order order = new Order(person, flight, 1);
        orderService.saveOrder(order);
    }

    public void cancelOrder(int id){
        orderService.cancelOrder(id);
    }

    public List<Order> searchOrderUser(String name, String surname){
       return orderService.searchOrder().stream()
                .filter(x -> x.getPeron().name == name && x.getPeron().surname == surname)
                .collect(Collectors.toList());
    }



}
