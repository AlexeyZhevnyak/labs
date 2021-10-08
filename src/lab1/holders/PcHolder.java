package lab1.holders;

import lab1.IDHolder;
import lab1.tables.PC;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PcHolder {
    private static int id = 0;
    private static final List<Integer> integers = IDHolder.set.stream().toList();
    public static Map<Integer, PC> map = new HashMap<>() {{
        put(integers.get(id), new PC(integers.get(id++), "Intel Core i5-9400", "Nvidia GTX 1060", 8, "Gigabyte B450M S2H (rev. 1.0)", 130001));
        put(integers.get(id), new PC(integers.get(id++), "AMD Ryzen 7 2700", "Nvidia GTX 2070", 16, "ASRock B460M Pro4", 130002));
        put(integers.get(id), new PC(integers.get(id++), "AMD Ryzen 3 1200", "Nvidia GTX 1050", 10, "ASRock B350M Pro2", 130003));
        put(integers.get(id), new PC(integers.get(id++), "AMD Ryzen 7 3750h", "Nvidia GTX 2070", 16, "Asus ROG Maximus XIII", 130004));
    }};
}
