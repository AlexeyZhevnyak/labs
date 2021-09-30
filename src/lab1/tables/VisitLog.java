package lab1.tables;

import lab1.AbstractTable;
import lab1.holders.EmployeeHolder;
import lab1.holders.PcHolder;
import lab1.holders.SubscriptionBuyHolder;

import java.sql.Date;
import java.util.Formatter;

public class VisitLog extends AbstractTable {
    private int idSubscriptionBuy;
    private int idPc;
    private int idEmployee;
    private Date date;

    public VisitLog(int id, int idSubscriptionBuy, int idPc, int idEmployee, Date date) {
        setId(id);
        this.idSubscriptionBuy = idSubscriptionBuy;
        this.idPc = idPc;
        this.idEmployee = idEmployee;
        this.date = date;
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
        return getEntryView();
    }

    @Override
    public String getEntryView() {
        return new Formatter().format("%20d  %20s  %20d  %40s  %20s",
                getId(),
                SubscriptionBuyHolder.map.get(idSubscriptionBuy).getSubscriptionType().getName(),
                PcHolder.map.get(idPc).getNumber(),
                EmployeeHolder.map.get(idEmployee).getFio(),
                date.toString()
        ).toString();
    }

    @Override
    public int hashCode() {
        return idSubscriptionBuy * idEmployee * idPc * 31;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
