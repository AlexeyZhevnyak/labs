package lab1;

import java.sql.Date;
import java.util.Formatter;

public class VisitLog {
    private int id;
    private int idSubscriptionBuy;
    private int idPc;
    private int idEmployee;
    private Date date;

    public VisitLog(int id, int idSubscriptionBuy, int idPc, int idEmployee, Date date) {
        this.id = id;
        this.idSubscriptionBuy = idSubscriptionBuy;
        this.idPc = idPc;
        this.idEmployee = idEmployee;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSubscriptionBuy() {
        return idSubscriptionBuy;
    }

    public void setIdSubscriptionBuy(int idSubscriptionBuy) {
        this.idSubscriptionBuy = idSubscriptionBuy;
    }

    public int getIdPc() {
        return idPc;
    }

    public void setIdPc(int idPc) {
        this.idPc = idPc;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return new Formatter().format("%20d  %20s  %20d  %40s  %20s",
                id,
                SubscriptionBuyings.map.get(idSubscriptionBuy).getSubscriptionType().getName(),
                PCs.map.get(idPc).getId(),
                Employees.map.get(idEmployee).getFio(),
                date.toString()
        ).toString();

    }
}
