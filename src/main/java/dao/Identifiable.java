package dao;

import java.io.Serializable;

public abstract class Identifiable implements Serializable {
    public final int id;

    public int getId() {
        return id;
    }

    protected Identifiable(int id) {
        this.id = id;
    }
}
