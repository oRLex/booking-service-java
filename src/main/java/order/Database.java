package order;

import dao.Identifiable;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collector;

public class Database {
    static File booking = new File("db/booking.bin");
    private static List<Identifiable> ordersList = new ArrayList<>();

    public static List<Identifiable> getOrdersList() throws IOException, ClassNotFoundException {
            if (booking.exists()){
                readFile(booking, ordersList);
            }
            return ordersList;
    }

    private static void saveFile(File file, List<Identifiable> list) throws IOException{
        FileOutputStream fos = new FileOutputStream(file);
        try(ObjectOutputStream oos = new ObjectOutputStream(fos)){
            for (Identifiable element: list) {
                oos.writeObject(element);
            }
        }
    }

    private static void readFile(File file, List<Identifiable> list) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        try(ObjectInputStream ois = new ObjectInputStream(fis)){
            Identifiable element;
            while (( element = (Identifiable) ois.readObject()) != null){
                list.add((Identifiable) element);
            }
        }
    }

}
