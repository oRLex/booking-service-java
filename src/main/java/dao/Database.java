package dao;

import flight.Flight;
import order.Order;
import utils.RandomFlights;

import java.io.*;
import java.util.*;

public class Database {
    static File booking = new File("./db","booking.bin");
    static File flights = new File("./db","flights.bin");

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
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
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

    private static void saveFile(File file, Set list) throws IOException{
        FileOutputStream fos = new FileOutputStream(file);
        try(ObjectOutputStream oos = new ObjectOutputStream(fos)){
            for (Object element: list) {
                oos.writeObject(element);
            }
        }
    }

    private static void readFile(File file, Set list) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        try(ObjectInputStream ois = new ObjectInputStream(fis)){
            Set element;
            while (( element =(Set) ois.readObject()) != null){
                list.add(element);
            }
        }
    }

    private static void close() throws IOException {
        saveFile(flights, flightSet);
        saveFile(booking, ordersList);
    }


}
