package order.service;


import flight.Flight;
import order.Order;
import order.collection.DaoOrderHashSet;
import person.Person;
import java.util.List;
import java.util.stream.Collectors;

public class OrderService {
   public final DaoOrderHashSet<Order> db = new DaoOrderHashSet<>();

   public void addOrder(String name, String surname, Flight flight){
        Person person = new Person(name, surname);
        Order order = new Order(person, flight, 1);
        db.saveOrder(order);
    }

    public List<Order> getAllOrders(){
      return db.searchOrder();
    }

    public void cancelOrder(int id){
        db.cancelOrder(id);
    }

    public List<Order> searchOrderUser(String name, String surname){
       return db.searchOrder().stream()
                .filter(x -> x.getPeron().name == name && x.getPeron().surname == surname)
                .collect(Collectors.toList());
    }
}
