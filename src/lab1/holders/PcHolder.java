package lab1.holders;

import lab1.tables.PC;

import java.util.HashMap;
import java.util.Map;

public class PcHolder {
    private static int id = 0;
    public static Map<Integer, PC> map = new HashMap<>() {{
        put(id, new PC(id++, "Intel Core i5-9400", "Nvidia GTX 1060", 8, "Gigabyte B450M S2H (rev. 1.0)", 130001));
        put(id, new PC(id++, "AMD Ryzen 7 2700", "Nvidia GTX 2070", 16, "ASRock B460M Pro4", 130002));
        put(id, new PC(id++, "AMD Ryzen 3 1200", "Nvidia GTX 1050", 10, "ASRock B350M Pro2", 130003));
        put(id, new PC(id++, "AMD Ryzen 7 3750h", "Nvidia GTX 2070", 16, "Asus ROG Maximus XIII", 130004));
    }};
}
