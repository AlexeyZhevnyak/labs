package lab1;

import java.util.HashMap;
import java.util.Map;

public class PCs {
    private static int id = 0;
    public static Map<Integer, PC> map = new HashMap<>() {{
        put(id, new PC(id++, "Intel Core i5-9400", "Nvidia GTX 1060", 8, "Gigabyte B450M S2H (rev. 1.0)"));
        put(id, new PC(id++, "AMD Ryzen 7 2700", "Nvidia GTX 2070", 16, "ASRock B460M Pro4"));
    }};
}
