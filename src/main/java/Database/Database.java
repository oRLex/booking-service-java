package Database;

import dao.Identifiable;
import flight.Flight;
import order.Order;
import utils.RandomFlights;

import java.io.*;
import java.util.*;

public class Database {
    public static File booking = new File("db/booking.bin");
    public static File flights = new File("db/flights.bin");

    private static Set<Order> ordersList = new HashSet<>();
    private static Set<Flight> flightSet = new HashSet<>();


    public static Set<Order> getOrdersList() {
        return ordersList;
    }

    public static Set<Flight> getFlightSet() {
        return flightSet;
    }

    static {
        try {
            init();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void init() throws IOException, ClassNotFoundException {
        if (flights.exists()){
            readFile(flights, flightSet);
        } else {
            RandomFlights randomFlights = new RandomFlights();
            flightSet.addAll(randomFlights.generateFlights());
            saveFile(flights, flightSet);
        }

        if (booking.exists()){
            readFile(booking , ordersList);
        }
    }

    public static void saveFile(File file, Set list) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        try(ObjectOutputStream oos = new ObjectOutputStream(fos)){
            for (Object element: list) {
                oos.writeObject(element);
            }
        } catch (Exception x){
            System.out.println(x.getMessage());
        }
    }

    private static void readFile(File file, Set list) throws IOException{
        FileInputStream fis = new FileInputStream(file);
        try(ObjectInputStream ois = new ObjectInputStream(fis)){
            while (true){
                Identifiable families = (Identifiable) ois.readObject();
               list.add(families);
            }
        } catch (Exception x){
            System.out.println(x.getMessage());
        }
    }

    public static void close() {
        try {
            saveFile(flights, flightSet);
            saveFile(booking, ordersList);
        } catch (Exception x){
            System.out.println(x.getMessage());
        }
    }


}
