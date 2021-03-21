package dao;

import flight.Flight;

import java.util.Optional;
import java.util.Set;

public interface FlightsDAO<T extends Identifiable>  {
    Set<T> getAll();
    Optional<T> getFlight(int id);
    Optional<T> getFlight(Flight f);
    void create(T f);
    void create(Set<T> sf);
}
