package person;

import java.io.Serializable;

public class Person implements Serializable {
    public final String name;
    public final String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return String.format("Person{name='%s', surname='%s'}", name, surname);
    }
}
