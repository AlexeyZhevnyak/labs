package lab1.holders;

import lab1.tables.Employee;

import java.util.HashMap;
import java.util.Map;

public class EmployeeHolder {
    private static int id = 0;
    public static Map<Integer, Employee> map = new HashMap<>() {{
        put(id, new Employee(id++, "Сухарев Андрей Сергеевич", "Администратор"));
        put(id, new Employee(id++, "Сурин Георгий Александрович", "Кассир"));
        put(id, new Employee(id++, "Топольцев Руслан Иванович", "Администратор"));
        put(id, new Employee(id++, "Иванов Иван Иванович", "Кассир"));
    }};
}
