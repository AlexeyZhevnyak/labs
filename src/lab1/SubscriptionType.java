package lab1;

public class SubscriptionType {
    private int id;
    private String name;
    private int monthPrice;

    public SubscriptionType(int id, String name, int monthPrice) {
        this.id = id;
        this.name = name;
        this.monthPrice = monthPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
