package dao;

public abstract class Identifiable {
    public final int id;

    public int getId() {
        return id;
    }

    protected Identifiable(int id) {
        this.id = id;
    }
}
