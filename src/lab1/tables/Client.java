package lab1.tables;

import lab1.AbstractTable;

import java.sql.Date;
import java.util.Formatter;

public class Client extends AbstractTable {
    private String fio;
    private String address;
    private Date birthday;

    public Client(int id, String fio, String address, Date birthday) {
        setId(id);
        this.fio = fio;
        this.address = address;
        this.birthday = birthday;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String getEntryView() {
        return new Formatter().format("%20d  %20s  %20s  %20s", getId(), fio, address, birthday.toString()).toString();
    }
}
