package lab1;

import java.sql.Date;

public class Client {
    private int id;
    private String fio;
    private String address;
    private Date birthday;

    public Client(int id, String fio, String address, Date birthday) {
        this.id = id;
        this.fio = fio;
        this.address = address;
        this.birthday = birthday;
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
}
