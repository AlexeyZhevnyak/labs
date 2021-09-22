import java.sql.Date;

public class VisitLog {
    private int id;
    private int idSubscriptionBuy;
    private int idPc;
    private int idEmployee;
    private Date date;

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
}
