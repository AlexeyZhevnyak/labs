package lab1.tables;

import lab1.AbstractTable;
import lab1.ITable;

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

    @Override
    public int compareTo(ITable o) {
        Client client = (Client) o;

        int t1 = this.fio.compareTo(client.fio);
        if (t1 == 0) {

            int t2 = this.address.compareTo(client.address);
            if (t2 == 0)
                return this.birthday.compareTo(client.birthday);

            return t2;
        }
        return t1;
    }
}
