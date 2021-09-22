package lab1;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public class SubscriptionBuyings {
    private static int id = 0;
    public static Map<Integer, SubscriptionBuy> map = new HashMap<>() {{
        put(id,
                new SubscriptionBuy(id++,
                        new SubscriptionType(1, "Standard", 100),
                        new Client(1, "Иванов Иван Иванович", "ул. Пушкина, 68", Date.valueOf("2002-04-02")),
                        Date.valueOf("2020-09-20")));
        put(id,
                new SubscriptionBuy(id++,
                        new SubscriptionType(2, "Premium", 200),
                        new Client(3, "Петров Петр Иванович", "ул. Советская, 90", Date.valueOf("2002-04-01")),
                        Date.valueOf("2020-08-20")));
    }};

}
