package dao;

import java.io.Serializable;

public abstract class Identifiable implements Serializable {
    public final int id;

    protected Identifiable(int id) {
        this.id = id;
    }
}
