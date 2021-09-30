package lab1.tables;

import lab1.AbstractTable;

import java.sql.Date;
import java.util.Formatter;

public class SubscriptionBuy extends AbstractTable {
    private SubscriptionType subscriptionType;
    private Client client;
    private Date date;

    public SubscriptionBuy(int id, SubscriptionType subscriptionType, Client client, Date date) {
        setId(id);
        this.subscriptionType = subscriptionType;
        this.client = client;
        this.date = date;
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String getEntryView() {
        return new Formatter().format("%20d  %20s  %20s %20s",
                getId(),
                subscriptionType.getName(),
                client.getFio(),
                date.toString()).toString();
    }
}
