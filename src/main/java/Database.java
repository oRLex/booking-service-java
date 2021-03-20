import dao.Identifiable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    static File booking = new File("db/booking.bin");

    static List<Identifiable> ordersList = new ArrayList<>();

    public void saveOrderInFile() throws IOException, ClassNotFoundException{
        if (booking.exists()){
            readFile(booking , ordersList);
        } else {
            saveFile(booking, ordersList);
        }
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
                list.add(element);
            }
        }
    }

}
