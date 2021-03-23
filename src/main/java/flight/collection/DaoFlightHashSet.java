package flight.collection;

import dao.Database;
import dao.FlightsDAO;
import flight.Flight;

import java.util.Optional;
import java.util.Set;

public class DaoFlightHashSet implements FlightsDAO<Flight> {
    Set<Flight> db;

    public DaoFlightHashSet(){
        db = Database.getFlightSet();
    }

    @Override
    public Set<Flight> getAll() {
        if (!db.isEmpty()) return db;
         else return null;
    }

    @Override
    public Optional<Flight> getFlight(int index) {
        return db.stream().filter(x-> x.id == index).findFirst();
    }

    @Override
    public Optional<Flight> getFlight(Flight f) {
        return Optional.empty();
    }

    @Override
    public void create(Flight f) {
            db.add(f);
    }

    @Override
    public void create(Set<Flight> sf) {
            db.addAll(sf);
    }


}
