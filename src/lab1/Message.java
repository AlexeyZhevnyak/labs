package lab1;

public class Message {
    private final String flag;
    private final ITable table;

    public Message(String flag, ITable table) {
        this.flag = flag;
        this.table = table;
    }

    @Override
    public String toString() {
        return flag + " - " + table;
    }
}
