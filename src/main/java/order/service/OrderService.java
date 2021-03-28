package order.service;
import dao.BookingDAO;
import order.Order;
import order.collection.DaoOrderHashSet;
import java.util.Collections;
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

    public  Set<Order>  searchOrder(String name, String surname) {
        Set<Order> orders = dao.getAll();
        try{
            return orders.stream()
                    .filter(x -> x.getPeron().name.equalsIgnoreCase(name) && x.getPeron().surname.equalsIgnoreCase(surname))
                    .collect(Collectors.toSet());
        } catch (Exception x){
            return Collections.emptySet();
        }
    }

    public Set<Order> getAll(){
        return dao.getAll();
    }

    public void cancelOrder(int id) {
        Set<Order> orders = dao.getAll();
        try{
            Optional<Order> gotFlight = orders.stream().filter(x -> x.id == id).findFirst();

            if (gotFlight.isPresent()) {
                dao.cancelOrder(gotFlight.get());
                return;
            }
        } catch (Exception x){
            System.out.println("не правильные данные");
        }
    }
}
