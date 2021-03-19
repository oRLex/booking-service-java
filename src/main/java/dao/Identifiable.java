package dao;

public abstract class Identifiable {
    public final int id;

    protected Identifiable(int id) {
        this.id = id;
    }
}
