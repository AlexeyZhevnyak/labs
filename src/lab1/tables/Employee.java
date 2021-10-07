package lab1.tables;

import lab1.AbstractTable;
import lab1.ITable;

import java.util.Formatter;

public class Employee extends AbstractTable {
    private String fio;
    private String position;

    public Employee(int id, String fio, String position) {
        setId(id);
        this.fio = fio;
        this.position = position;
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

    @Override
    public String getEntryView() {
        return new Formatter().format("%20d  %20s  %20s", getId(), fio, position).toString();
    }

    @Override
    public int compareTo(ITable o) {
        Employee employee = (Employee) o;
        int t1 = this.fio.compareTo(employee.fio);

        if (t1 == 0)
            return this.position.compareTo(employee.position);

        return t1;
    }
}
