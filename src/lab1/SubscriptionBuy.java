package lab1;

import java.sql.Date;

public class SubscriptionBuy {
    private int id;
    private SubscriptionType subscriptionType;
    private Client client;
    private Date date;

    public SubscriptionBuy(int id, SubscriptionType subscriptionType, Client client, Date date) {
        this.id = id;
        this.subscriptionType = subscriptionType;
        this.client = client;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
