package lab1.tables;

import lab1.AbstractTable;
import lab1.ITable;

import java.util.Formatter;

public class SubscriptionType extends AbstractTable {
    private String name;
    private int monthPrice;

    public SubscriptionType(int id, String name, int monthPrice) {
        setId(id);
        this.name = name;
        this.monthPrice = monthPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonthPrice() {
        return monthPrice;
    }

    public void setMonthPrice(int monthPrice) {
        this.monthPrice = monthPrice;
    }


    @Override
    public String getEntryView() {
        return new Formatter().format("%20d  %20s %20d", getId(), name, monthPrice).toString();
    }

    @Override
    public int compareTo(ITable o) {
        SubscriptionType subscriptionType = (SubscriptionType) o;
        int t1 = this.name.compareTo(subscriptionType.name);
        if (t1 == 0) {

            return this.monthPrice - subscriptionType.monthPrice;
        }
        return t1;
    }
}
