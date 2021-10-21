package lab1.holders;

import lab1.tables.Client;
import lab1.tables.SubscriptionBuy;
import lab1.tables.SubscriptionType;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public class SubscriptionBuyHolder {
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
        put(id,
                new SubscriptionBuy(id++,
                        new SubscriptionType(3, "Base", 300),
                        new Client(3, "Соболев Петр Иванович", "ул. Советская, 90", Date.valueOf("2002-04-03")),
                        Date.valueOf("2020-08-20")));
        put(id,
                new SubscriptionBuy(id++,
                        new SubscriptionType(3, "Base", 300),
                        new Client(3, "Афанасенко Николай Иванович", "ул. Белорусская, 4", Date.valueOf("2002-11-09")),
                        Date.valueOf("2020-09-20")));
    }};

}
