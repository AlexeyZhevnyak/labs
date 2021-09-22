import java.util.HashMap;
import java.util.Map;

public class SubscriptionBuyings {
    private static Map<Integer, SubscriptionBuy> map = new HashMap<>() {{
        put(id++, new SubscriptionBuy());
    }};
    private static int id = 0;
}
