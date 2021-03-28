package dao;

import java.util.Optional;
import java.util.Set;

public interface FlightsDAO<Flight>  {
    Set<Flight> getAll();
    Optional<Flight> getFlight(int index);
    Optional<Flight> getFlight(Flight f);
    void create(Flight f);
    void create(Set<Flight> sf);
}
