package lab1;

public class Employee {
    private int id;
    private String fio;
    private String position;

    public Employee(int id, String fio, String position) {
        this.id = id;
        this.fio = fio;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
