package lab1.tables;

import lab1.AbstractTable;

import java.util.Formatter;

public class SubscriptionType extends AbstractTable implements Comparable<SubscriptionType> {
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
    public int compareTo(SubscriptionType o) {
        return name.compareTo(o.getName());
    }

    @Override
    public String getEntryView() {
        return new Formatter().format("%20d  %20s %20d", getId(), name, monthPrice).toString();
    }
}
