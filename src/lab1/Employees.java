package lab1;

import java.util.HashMap;
import java.util.Map;

public class Employees {
    private static int id = 0;
    public static Map<Integer, Employee> map = new HashMap<>() {{
        put(id, new Employee(id++, "Сухарев Андрей Сергеевич", "Администратор"));
        put(id, new Employee(id++, "Сурин Георгий Александрович", "Кассир"));
    }};
}
