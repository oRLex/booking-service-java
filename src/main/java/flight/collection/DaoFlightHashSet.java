package flight.collection;

import dao.FlightsDAO;
import dao.Identifiable;
import flight.Flight;
import utils.RandomFlights;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class DaoFlightHashSet<T extends Identifiable> implements FlightsDAO<T> {

    private final Set<T> db = new HashSet<>();

    public DaoFlightHashSet(){

    }

    @Override
    public Set<T> getAll() {
        if (!db.isEmpty()) return db;
         else return null;
    }

    @Override
    public Optional<T> getFlight(int id) {
        return db.stream().filter(x -> x.id == id).findFirst();
    }

    @Override
    public Optional<T> getFlight(Flight f) {
        return Optional.empty();
    }

    @Override
    public void create(T f) {
            db.add(f);
    }

    @Override
    public void create(Set<T> sf) {
            db.addAll(sf);
    }


}
