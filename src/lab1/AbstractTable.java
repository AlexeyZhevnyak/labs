package lab1;

public abstract class AbstractTable implements ITable {
    private int id;

    public int getId() {
        return id;
    }

    public final void setId(int id) {
        this.id = id;
    }
}
