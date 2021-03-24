package person;

public class Person {
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
